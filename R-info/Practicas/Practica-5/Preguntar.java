programa ejemplo
procesos
  proceso recorrerAvenida
  comenzar
    repetir 10
      mover
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot robot1
  variables
    id: numero
  comenzar
    RecibirMensaje(id, r)
    recorrerAvenida
    EnviarMensaje(id, r)
  fin
  robot jefe
  variables
    id: numero
    ganador: numero
  comenzar
    ganador:= 0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    repetir 2
      RecibirMensaje(id, *)
      si(id = 1)
        ganador:= id
      sino
        si(id = 2)
          ganador:=id
        sino
          ganador:=id
    Informar(ganador)
  fin
variables
  r1: robot1
  r2: robot1
  r3: robot1
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r, ciudad)
  AsignarArea(r3, ciudad)
  Iniciar(r3, 3,1)
  Iniciar(r1, 1,1)
  Iniciar(r2, 2,1)
  Iniciar(r, 7,1)
fin
