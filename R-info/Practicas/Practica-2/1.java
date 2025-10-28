programa ejemplo
procesos
  proceso recorrerAvenida
  comenzar
    repetir 4
      mover
  fin
      
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    i, a: numero
  comenzar
    a:= 1
    i:= PosAv()
    repetir 9
      recorrerAvenida
      i:= i + 1
      Pos(i, a)
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
  Iniciar(r2, 10, 1)
  Iniciar(r3, 19, 1)
fin
