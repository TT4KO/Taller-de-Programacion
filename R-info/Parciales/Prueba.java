programa ejemplo
procesos
  proceso recorrerAvenida
  comenzar
    repetir 9
      si(PosAv = 6) & (PosCa = 10)
        BloquearEsquina(6, 10)
        mover
        LiberarEsquina(6, 10)
      sino
        si(PosAv = 10) & (PosCa = 6)
          BloquearEsquina(10, 6)
          mover
          LiberarEsquina(10, 6)  
        sino      
          mover 
    derecha
  fin
areas
  ciudad: AreaP (1,1,10,5)
  ciudad2: AreaP (1,6,5,10)
  zona: AreaPC(6, 6, 10, 10)
  ciudad3: AreaP (11, 6, 15 , 10)
  ciudad4: AreaP (6, 11, 15, 15) 
robots
  robot robot1
  comenzar
    repetir 16
      recorrerAvenida
  fin
  robot robot2
  variables
    run: boolean
  comenzar
    repetir 2
      derecha
    repetir 16
      recorrerAvenida
  fin
variables
  r1: robot1
  r2: robot2
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r1, ciudad2)
  AsignarArea(r1, zona)
  AsignarArea(r2, ciudad3)
  AsignarArea(r2, ciudad4)
  AsignarArea(r2, zona)
  Iniciar(r1, 1,1)
  Iniciar(r2, 15, 15)
fin
