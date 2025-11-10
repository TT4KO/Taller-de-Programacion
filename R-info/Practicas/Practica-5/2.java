programa ejemplo
procesos
  proceso busqueda(ES total: numero)
  comenzar
    Pos(50, 50)
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      total:=total + 1
  fin
  proceso dejar(ES f: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(50, 50)
    Pos(50, 50)
    mientras(f <> 0)
      depositarFlor
      f:=f - 1
    Pos(avenida, calle)
    LiberarEsquina(50, 50)
  fin
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso actuar(ES f: numero)
  comenzar
    repetir 10
      si(PosAv < 100)
        juntar(f)
        mover
    dejar(f)
  fin
  proceso barrera(E id: numero; E ok: boolean)
  comenzar
    si(id = 1)
      EnviarMensaje(ok, r2)
      EnviarMensaje(ok, r3)
      RecibirMensaje(ok, r2)
      RecibirMensaje(ok, r3)
    sino
      si(id = 2)
        EnviarMensaje(ok, r1)
        EnviarMensaje(ok, r3)
        RecibirMensaje(ok, r1)
        RecibirMensaje(ok, r3)
      sino
        EnviarMensaje(ok, r1)
        EnviarMensaje(ok, r2)
        RecibirMensaje(ok, r1)
        RecibirMensaje(ok, r2)
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot juntadores
  variables
    id, f: numero
    iniciar: boolean
  comenzar
    RecibirMensaje(id, r)
    f:=0
    derecha
    repetir 10
      actuar(f)
      barrera(id, iniciar)
    EnviarMensaje(iniciar,r)
  fin
  robot jefe
  variables
    iniciar: boolean
    total, id: numero
  comenzar
    total:=0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    RecibirMensaje(id, r3)
    RecibirMensaje(iniciar, *)
    busqueda(total)
    Informar(total)
  fin
variables
  r1: juntadores
  r2: juntadores
  r3: juntadores
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 1,2)
  Iniciar(r3, 1,3)
  Iniciar(r, 1,4)
fin
