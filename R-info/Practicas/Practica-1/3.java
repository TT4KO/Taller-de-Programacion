programa ejemplo
procesos
  proceso agarrar(ES f: numero; ES p:numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:= p + 1
  fin
  proceso moverse(E escalon: numero; ES f: numero; ES p: numero; ES total: numero)
  comenzar
    repetir 2
      repetir escalon
        agarrar(f, p)
        mover
      derecha 
    repetir 2
      derecha
  fin
  proceso escalonado(ES escalon: numero; E f: numero; E p: numero; E total: numero)
  variables
    escalon, f, p, total: numero
  comenzar
    total:= 0
    f:=0
    p:=0
    escalon:= 1
    repetir 4
      moverse(escalon, f, p, total)
      escalon:= escalon + 1
      si(f - p = 1)
        total:= total + 1
  fin    
      
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    total, f, p , escalon: numero
  comenzar
    escalonado(escalon, f, p, total)
    Informar(total)
  fin
variables
  r1: robot1
  r2: robot1
  r3: robot1
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 3, 1)
  Iniciar(r3, 5, 1)
fin
