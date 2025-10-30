programa ejemplo
procesos
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
areas
  ciudad: AreaPC (1, 1, 5, 10)
  inicio1: AreaPC(6, 9, 8, 10)
robots
  robot floreros
  variables 
    main:boolean
    f, rdmcalle, rdmavenida, calle, avenida: numero
  comenzar
    f:=0
    calle:= PosCa
    avenida:= PosAv
    repetir 4
      Random(rdmcalle, 1, 10)
      Random(rdmavenida, 1, 5)
      BloquearEsquina(rdmavenida, rdmcalle)
      Pos(rdmavenida, rdmcalle)
      juntar(f)
      Pos(avenida, calle)
      LiberarEsquina(rdmavenida, rdmcalle)
    BloquearEsquina(10, 10)
    mientras(f <> 0)
      depositarFlor
      f:=f - 1
    LiberarEsquina(5, 5)
  fin
variables
  r1, r2: floreros
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r1, inicio1)
  AsignarArea(r2, inicio1)
  Iniciar(r1, 6,10)
  Iniciar(r2, 7,10)
fin
