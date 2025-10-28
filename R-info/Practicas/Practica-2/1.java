programa ejemplo
procesos
  proceso juntar(ES flor: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      flor:=flor + 1
  fin
  proceso recorrerAvenida(ES flor: numero)
  comenzar
    repetir 4
      juntar(flor)
      mover
  fin
      
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    i, a, flor, dif, floresotro: numero
  comenzar
    flor:= 0
    a:= 1
    i:= PosAv()
    repetir 9
      recorrerAvenida(flor)
      i:= i + 1
      Pos(i, a)
    RecibirMensaje(floresotros, r2)
    si(flor > floresotros)
      dif:= flor - floresotros
      Informar(dif)
    sino
      dif:=floresotros - flor
      Informar(dif)
    EnviarMensaje(flor, r1)
  fin
variables
  r1: robot1
  r2: robot1
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 10, 1)

fin
