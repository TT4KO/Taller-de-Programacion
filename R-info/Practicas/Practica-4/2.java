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
    mientras(cant <> 0)
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
    cant:=0
    mientras(cant <> 5) & (PosCa < 100)
      si(HayFlorEnLaEsquina)
        tomarFlor
        cant:=cant + 1
      mover
    calle:=PosCa
    avenida:=PosAv
    si(cant > 0)
      BloquearEsquina(50, 50)
      Pos(50, 50)
      repetir cant
        depositarFlor
      Pos(avenida, calle)
      LiberarEsquina(50, 50) 
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot juntadores
  comenzar
    mientras(PosCa < 100)
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
  Iniciar(r4, 7,1)
  Iniciar(r3, 8,1)
  Iniciar(r1, 5,1)
  Iniciar(r2, 10,1)
fin
