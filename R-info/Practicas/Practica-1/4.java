programa ejemplo
procesos
  proceso juntar(ES flor: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      flor:= flor + 1
  fin
  proceso movimiento1(ES flor: numero)
  comenzar
    repetir 99
      juntar(flor)
      mover
    derecha
    repetir 24
      mover
    derecha
  fin
  
  proceso juntar2(ES papel: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      papel:= papel + 1
  fin
  proceso movimiento2(ES papel: numero)
  comenzar
    repetir 25
      juntar2(papel)
      mover
    derecha
    repetir 24
      mover
    derecha
  fin
areas
  ciudad: AreaC (1,1,100,100)
  
robots
  robot robot1
  variables 
    flor: numero
  comenzar
    flor:=0
    repetir 2
      movimiento1(flor)
    Pos(51, 1)
    repetir 2
      movimiento1(flor)
    Informar(flor)
  fin
  
  robot robot2
  variables
    papel: numero
  comenzar
    papel:=0
    repetir 2
      movimiento2(papel)
    Pos(76, 1)
    repetir 2
      movimiento2(papel)
    Informar(papel)
  fin
variables
  r1: robot1
  r2: robot2
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 26, 1)
fin
