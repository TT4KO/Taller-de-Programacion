programa ejemplo
procesos
  proceso juntar(ES f: numero; ES corte: boolean)
  comenzar
    mientras(HayFlorEnLaEsquina)
      mover
      tomarFlor
      f:= f + 1
    si(f <> 0) & (PosAv < 10)
      repetir f
        mover
        depositarFlor
        f:=f - 1
    sino
      corte:= V
  fin
  proceso dejar(E avenida: numero; ES calle: numero; E cant: numero)
  comenzar
    calle:= calle + 1
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    repetir cant
      depositarFlor
    Pos(3,1)
    LiberarEsquina(avenida, calle)
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    calle, i, avenida,id, cant, f: numero
    iniciar, corte: boolean
  comenzar
    corte:=F
    f:=0
    RecibirMensaje(id, r)
    avenida:=PosAv
    mientras(corte = F)
      calle:=PosCa
      Random(cant, 1, 4)
      EnviarMensaje(avenida, r)
      EnviarMensaje(calle, r)
      EnviarMensaje(cant, r)
      RecibirMensaje(iniciar, r1)
      juntar(f, corte)
    EnviarMensaje(corte, r) 
  fin
  robot jefe
  variables
    calle, avenida, cant, id: numero
    iniciar, corte: boolean
  comenzar
    EnviarMensaje(1, r1)
    mientras(corte = F)
      RecibirMensaje(avenida, r1)
      RecibirMensaje(calle, r1)
      RecibirMensaje(cant, r1)
      dejar(avenida, calle, cant)
      EnviarMensaje(V, r1)
      RecibirMensaje(corte, r1)
  fin
variables
  r1: robot1
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r, 3,1)
fin
