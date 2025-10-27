programa ejemplo
procesos
  proceso girarDerecha(E cantVeces: numero)
  comenzar
    repetir cantVeces
      derecha
  fin
  proceso recorrerAvenida(E pasos: numero)
  comenzar
    repetir pasos
      mover
  fin

areas
  ciudad: AreaC (10,10,20,20)
  
robots
  robot robot1
  comenzar
    recorrerAvenida(10)
  fin
  
  robot robot2
  comenzar
    girarDerecha(1)
    recorrerAvenida(10)
  fin
  
  robot robot3
  comenzar
    girarDerecha(2)
    recorrerAvenida(10)
  fin
  
  robot robot4
  comenzar
    girarDerecha(3)
    recorrerAvenida(10)
  fin
  
variables
  info: robot1
  info2: robot2
  info3: robot3
  info4: robot4
comenzar
  AsignarArea(info, ciudad)
  AsignarArea(info2, ciudad)
  AsignarArea(info3, ciudad)
  AsignarArea(info4, ciudad)
  Iniciar(info, 10,10)
  Iniciar(info2, 10, 20)
  Iniciar(info3, 20, 20)
  Iniciar(info4, 20, 10)
fin
