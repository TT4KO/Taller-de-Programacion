programa ejemplo
procesos
  proceso girarDerecha(E cantVeces: numero)
  comenzar
    repetir cantVeces
      derecha
  fin
  proceso recorrerAvenida(ES cant: numero)
  comenzar
    repetir 10
      mientras(HayPapelEnLaEsquina)
        tomarPapel
        cant:= cant + 1
      mover
  fin

areas
  ciudad: AreaC (10,10,20,20)
  
robots
  robot robot1
  variables
    cant: numero
  comenzar
    cant:= 0
    recorrerAvenida(cant)
    Informar(cant)
  fin
  
  robot robot2
  variables
    cant: numero
  comenzar
    cant:=0
    girarDerecha(1)
    recorrerAvenida(cant)
    Informar(cant)
  fin
  
variables
  info: robot1
  info2: robot2
comenzar
  AsignarArea(info, ciudad)
  AsignarArea(info2, ciudad)
  Iniciar(info, 10,10)
  Iniciar(info2, 10, 20)
fin
