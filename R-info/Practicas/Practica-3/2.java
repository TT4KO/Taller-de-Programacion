programa ejemplo
procesos
  proceso girar(E cant: numero)
  comenzar
    repetir cant
      derecha
  fin
  proceso desplazamiento(E cant: numero)
  comenzar
    repetir cant
      mover
  fin
  proceso movimiento(E pasos: numero; E giro: numero)
  comenzar
    repetir pasos
      mover
    derecha
    repetir pasos
      mover
    repetir giro
      derecha
  fin
  proceso movimiento2(E pasos: numero; E giro: numero)
  comensar
    repetir pasos
      mover
    repetir giro
      derecha
areas
  ciudad: AreaP (1,1,50,50)
robots
  robot robot1
  variables
    pasos, giro: numero
  comenzar
    pasos:= 5
    giro:= 3
    repetir 5
      movimiento(pasos, giro)
      pasos:= pasos - 1
    girar(3)
    desplazamiento(3)
    derecha
    repetir 5
      pasos:= 2
      giro:= 3
  fin
variables
  r1: robot1
comenzar
  AsignarArea(r1, ciudad)
  Iniciar(r1, 1,1)
fin
