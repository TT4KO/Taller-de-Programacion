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
    repetir 4
      juntar(cantf)
      mover
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    cantf, id: numero
    c, a: numero
  comenzar
    cantf:= 0
    a:=1
    c:=PosAv()
    a:=1
    repetir 9
      recorrerAvenida(cantf)
      c:=c + 1
      Pos(c, a)
    EnviarMensaje(id, r)
    EnviarMensaje(cantf, r)
  fin
  robot jefe
  variables
    f, mayor, ganador, dinf, id: numero
  comenzar
    mayor:= 0
    ganador:= 0
    repetir 3
      RecibirMensaje(id, *)
      RecibirMensaje(f, *)
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
  r4: robot1
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r4, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 11, 1)
  Iniciar(r3, 20, 1)
  Iniciar(r4, 30, 1)
  Iniciar(r, 1, 100)
fin
