programa ejemplo
procesos
  proceso limpiar(ES cant: numero)
  comenzar
    mientras (HayPapelEnLaEsquina)
      tomarPapel
      cant:= cant + 1
  fin
 
areas
  ciudad: AreaC (10,10,20,20)

robots
  robot robott
  variables
    cant: numero
  comenzar
    cant := 0
    derecha
    repetir 10
      si (HayPapelEnLaEsquina)
          limpiar(cant)
        mover
    fin
    repetir cant
      depositarPapel
    fin
    Informar(cant)
  fin
  
variables
  robot1: robott
  robot2: robott
  robot3: robott
  robot4: robott
comenzar
  AsignarArea(robot1, ciudad)
  Iniciar(robot1, 10,10)
fin
