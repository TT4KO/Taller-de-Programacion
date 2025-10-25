programa ejemplo
procesos
  proceso juntar(ES flor: numero)
  comenzar
    mientras (HayFlorEnLaEsquina)
      tomarFlor
      flor := flor + 1
   
  fin

areas
  ciudad: AreaC (1,1,10,15)

robots
  robot robot1
  variables
    flor, sinFlores: numero
  comenzar
    flor := 0
    sinFlores := 0

    repetir 14
      si (HayFlorEnLaEsquina)
        juntar(flor)
      sino
        sinFlores := sinFlores + 1     
      mover      
    repetir flor
      depositarFlor
    
    Informar(flor)
    Informar(sinFlores)
  fin

variables
  R_info: robot1
comenzar
  AsignarArea(R_info, ciudad)
  Iniciar(R_info, 1, 1)
fin
