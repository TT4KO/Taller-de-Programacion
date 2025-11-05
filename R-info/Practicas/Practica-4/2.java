programa ejemplo
procesos
  proceso juntar(ES cant: numero; ES corte: numero)
  variables
    calle, avenida, f: numero
  comenzar
    f:= 0
    calle:= PosCa
    avenida:= PosAv
    BloquearEsquina(50, 50)
    Pos(50, 50)
    si(HayFlorEnLaEsquina)
      repetir cant
        tomarFlor
        f:= f +1
        cant:=cant - 1
      Pos(avenida, calle)
      LiberarEsquina(50, 50)
      mientras(f <> 0)
        depositarFlor
        f:= f - 1
    sino
      corte:=corte - 1
      Pos(avenida, calle)
      LiberarEsquina(50, 50)
  fin
  proceso moverse
  variables
    cant, calle, avenida:numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    cant:=0
    mientras(cant <> 5)
      si(HayFlorEnLaEsquina)
        tomarFlor
        cant:=cant + 1
        mover
    BloquearEsquina(50, 50)
    Pos(50, 50)
    repetir 5
      depositarFlor
      Pos(PosAv, PosCa)
    LiberarEsquina(50, 50) 
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot juntadores
  comenzar
    mientras(PosCa < 99)
      moverse
  fin
  robot cliente
  variables
    cant, corte: numero
  comenzar
    corte:= 8
    mientras(corte <> 0)
      Random(cant, 2, 5)
      juntar(cant, corte)
  fin
variables
  r1: juntadores
  r2: juntadores
  r3: cliente
  r4: cliente
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r4, ciudad)
  Iniciar(r1, 5,1)
  Iniciar(r2, 10,1)
  Iniciar(r3, 1,1)
  Iniciar(r4, 2,1)
fin
