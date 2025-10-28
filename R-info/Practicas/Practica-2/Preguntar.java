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
    cantf, id: numero
    calle, av: numero
  comenzar
    cantf:= 0
    calle:=1
    av:=1
    repetir 9
      recorrerAvenida(cantf)
      calle:= calle + 1
      Pos(av, calle)
    EnviarMensaje(id, r)
    EnviarMensaje(cantf, r)
  fin
  robot jefe
  variables
    f, mayor, ganador, dinf, i: numero
  comenzar
    mayor:= 0
    ganador:= 0
    repetir 3
      RecibirMensaje(f, *)
      RecibirMensaje(id, *)
      si(f > mayor)
        mayor:= f
        ganador:= id
    Informar(ganador)
    Informar(mayor)
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

  Iniciar(r1, 1,1)
  Iniciar(r2, 11, 1)
  Iniciar(r3, 20, 1)
  Iniciar(r, 1, 100)
fin
