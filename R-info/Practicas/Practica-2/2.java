programa ejemplo
procesos
  proceso juntar(ES f: numero; ES p: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:= p +1
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
  proceso moverse(E rdm: numero; ES f: numero; ES p: numero)
  comenzar
    repetir rdm
      juntar(f, p)
      mover
    derecha
    mover
    repetir 3
      derecha
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    rdm: numero
    f, p: numero
    escalon: numero
  comenzar
    escalon:= 0
    f:= 0
    p:= 0
    repetir 4
      Random(rdm, 1, 5)
      moverse(rdm, f, p)
      si(f > p)
        escalon:= escalon + 1
    EnviarMensaje(escalon, r)
    EnviarMensaje(f, r)
  fin
  robot jefe
  variables
    f: numero
    total: numero
    escalon: numero
  comenzar
    escalon:= 0
    total:= 0
    repetir 3
      RecibirMensaje(escalon, *)
      RecibirMensaje(f, *)
      total:= total + f
    Informar(total)
    Informar(escalon)
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
  Iniciar(r2, 2,1)
  Iniciar(r3, 7,1)
  Iniciar(r, 12, 1)
fin
