/*Tres robots recolectores deben coordinarse para recolectar todas los papeles de la calle 2. desde las avenidas 1 a la 61. 
 Para ello, el primer robot realiza un tramo de 20 esquinas, cuando termina avisa al segundo robot para que realice el segundo tramo de 
 21 esquinas, y cuando éste finaliza avisa al tercer robot para que realice el tramo final de 22 esquinas, Además, luego de realizar cada tramo, 
 los robots deben depositar de a uno los papeles juntados en la esquina (3.20) Una vez que los 3 recolectores han finalizado, un robot jefe debe 
 avisar al robot que junto menos papeles durante su tramo, que recoja los papeles que fueron depositados en la esquina (3,20) Cada robot recolector 
inicia al comienzo de su tramo. El robot jefe inicia en la esquina (2.1)*/
programa ejemplo
procesos
  proceso buscar(ES total: numero)
  comenzar
    Pos(3, 20)
    mientras(total < 0)
      tomarPapel
      total:=total - 1
    Pos(1, 2)
  fin
  proceso actualizar(ES cant: numero; ES maxid: numero; ES id: numero ;ES max:numero)
  comenzar
    si(cant < max)
      max:=cant
      maxid:= id
  fin
  proceso juntar(ES p: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:= p + 1
  fin
  proceso dejar(ES p: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(3, 20)
    Pos(3, 20)
    mientras(p <> 0)
      depositarPapel
      p:= p - 1
    Pos(avenida, calle)
    LiberarEsquina(3, 20)
  fin
  proceso moverse(ES cant: numero)
  variables
    p: numero
  comenzar
    p:=0
    repetir 20
      juntar(p)
      cant:=cant + p
      mover
    dejar(p)
  fin
  proceso activar(E ok:boolean; E id: numero; ES cant: numero)
  comenzar
    si(id = 1)
      moverse(cant)
      EnviarMensaje(ok, r2)
      RecibirMensaje(ok, r3)
    sino
      si(id = 2)
        RecibirMensaje(ok, r1)
        moverse(cant)
        EnviarMensaje(ok, r3)
      sino
        RecibirMensaje(ok, r2)
        moverse(cant)
        EnviarMensaje(ok, r1)
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    id: numero
    ok: boolean
    cant: numero
  comenzar 
    cant:=0
    RecibirMensaje(id, r)
    derecha
    activar(ok, id, cant)
    EnviarMensaje(id, r)
    EnviarMensaje(cant, r)
  fin
  robot jefe
  variables
    id, cant, total, max, maxid: numero
  comenzar
    total:=0
    max:=9999
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    repetir 3
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(cant, r1)
        actualizar(cant, maxid, id, max)
        total:=total + cant
      sino
        si(id = 2)
          RecibirMensaje(cant, r2)
          actualizar(cant, maxid, id, max)
          total:=total + cant
        sino
          RecibirMensaje(cant, r3)
          actualizar(cant, maxid, id, max)
          total:=total + cant
    buscar(total)
    Informar(maxid)
  fin
variables
  r1: robot1
  r2: robot1
  r3: robot1
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,2)
  Iniciar(r2, 22,2)
  Iniciar(r3, 43,2)
  Iniciar(r, 2,1)
fin
