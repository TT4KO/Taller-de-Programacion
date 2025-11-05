programa ejemplo
procesos
  proceso moverse(ES corte: boolean)
  comenzar
    si(PosCa < 100)
      repetir 5
        mover
        si(HayPapelEnLaEsquina)
          tomarPapel
    sino
      corte:= V
  fin
areas
  ciudad: AreaP (1,1,4,100)
robots
  robot run1
  variables
    id: numero
    iniciar, corte: boolean
  comenzar
    corte:=F
    RecibirMensaje(id, r)
    mientras(corte = F)
      moverse(corte)
      EnviarMensaje(corte, r2)
      EnviarMensaje(iniciar, r2)
      RecibirMensaje(corte, r3)
      RecibirMensaje(iniciar, r3)
  fin
  robot run2
  variables
    id: numero
    iniciar, corte: boolean
  comenzar
    corte:= F
    RecibirMensaje(id, r)
    mientras(corte = F)
      RecibirMensaje(corte, r1)
      RecibirMensaje(iniciar, r1)
      moverse(corte)
      EnviarMensaje(corte, r3)
      EnviarMensaje(iniciar, r3)
  fin
  robot run3
  variables
    id: numero
    iniciar, corte: boolean
  comenzar
    RecibirMensaje(id, r)
    corte:= F
    mientras(corte = F)
      RecibirMensaje(corte, r2)
      RecibirMensaje(iniciar, r2)
      moverse(corte)
      EnviarMensaje(corte, r1)
      EnviarMensaje(iniciar, r1) 
  fin
  robot jefe
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
  fin
variables
  r1: run1
  r2: run2
  r3: run3
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r, 4, 1)
  Iniciar(r1, 1,1)
  Iniciar(r2, 2,1)
  Iniciar(r3, 3,1)
fin
