/*Existen 4 robots recolectores y un robot jefe. Los robots recolectores deben juntar las flores y papeles de un área en común, en cinco intentos. 
Para realizar esta tarea elijen una esquina al azar dentro del área, se posicionan y toman los papeles y flores. 
Cada vez que juntan una flor o papel de esa esquina le avisan al jefe. Al terminar de juntar los papeles y flores vuelve a su esquina original.
El jefe va recibiendo los avisos de los robots recolectores y cuando todos terminan les avisa quien juntó más papeles y flores. 
El robot recolector que más juntó debe depositarios en su esquina original.
Notas: El área común está delimitada por las esquina inferior izquierda (45,48) y la superior derecha (62,69).
El robot recolector1 se posiciona inicialmente en la esquina (10,10)
El robot recolector2 se posiciona inicialmente en la esquina (11,10)
El robot recolector3 se posiciona inicialmente en la esquina (12.10)
El robot recolector4 se posiciona inicialmente en la esquina (13,10)
El robot recolector1 se posiciona inicialmente en la esquina (1,1)*/


programa ejemplo
procesos
  proceso actualizar(E total: numero; E id: numero; ES max: numero; ES ganador: numero)
  comenzar
    si(total > max)
      max:=total
      ganador:=id
  fin
  proceso juntar(E avenida: numero; E calle: numero; ES f: numero; ES p: numero)
  variables
    mica, miav: numero
  comenzar
    mica:=PosCa
    miav:=PosAv
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f+1
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:=p + 1
    Pos(miav, mica)
    LiberarEsquina(avenida, calle)
  fin
areas
  ciudad: AreaPC (45,48,62,69)
  poso: AreaP(1, 1, 1,1)
  zona: AreaP(10, 10, 13, 10)
robots
  robot cliente
  variables
    calle, avenida, id, f, p, total: numero
  comenzar
    total:=0
    f:=0
    p:=0
    RecibirMensaje(id, r)
    repetir 5
      Random(calle, 48, 69)
      Random(avenida, 45, 62)
      juntar(avenida, calle, f, p)
    total:= f + p
    EnviarMensaje(id, r)
    EnviarMensaje(total, r)
  fin
  robot jefe
  variables
    id: numero
    max, ganador, total: numero
  comenzar
    max:=-1
    total:=0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4)
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(total, r1)
        actualizar(total, id, max, ganador)
      sino
        si(id = 2)
          RecibirMensaje(total, r2)
          actualizar(total, id, max, ganador)
        sino
          si(id = 3)
            RecibirMensaje(total, r3)
            actualizar(total, id, max, ganador)
          sino
            RecibirMensaje(total, r4)    
            actualizar(total, id, max, ganador)
    Informar('ganador', ganador)
  fin
variables
  r1: cliente
  r2: cliente
  r3: cliente
  r4: cliente
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r4, ciudad)
  AsignarArea(r1, zona)
  AsignarArea(r2, zona)
  AsignarArea(r3, zona)
  AsignarArea(r4, zona)
  AsignarArea(r, poso)
  Iniciar(r, 1,1)
  Iniciar(r1, 10,10)
  Iniciar(r2, 11,10)
  Iniciar(r3, 12,10)
  Iniciar(r4, 13,10)
fin
