programa ejemplo
procesos
  proceso juntar(ES cantf: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      cantf:= cantf + 1
  fin
  proceso recorrerAvenida(ES cantf: numero)
  comenzar
    repetir 10
      juntar(cantf)
      mover
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    cantf: numero
    calle: numero
  comenzar
    cantf:= 0
    calle:= 1
    repetir 9
      recorrerAvenida(cantf)
      calle:= calle + 1
      Pos(calle, 1)
    EnviarMensaje(cantf, r)
  fin
  robot robot2
  variables
    calle: numero
    cantf: numero
  comenzar
    cantf:= 0
    calle:= 11
    repetir 10
      recorrerAvenida(cantf)
      calle:= calle + 1
      Pos(calle, 1) 
    EnviarMensaje(cantf, r)
  fin
  robot jefe
  variables
    f1, f2, dif: numero
  comenzar
    RecibirMensaje(f1, *)
    RecibirMensaje(f2, robot2)
    si(f1 > f2)
      dif:=f1 - f2
    sino
      dif:= f2 - f1
    Informar(dif)
  fin
variables
  r1: robot1
  r2: robot2
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 11, 2)
  Iniciar(r, 11, 1)
fin
