programa ejemplo
procesos
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso actuar(ES f: numero)
  comenzar
    repetir 99
      juntar(f)
      mover
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot equipoa
  variables
    f, id: numero
  comenzar
    RecibirMensaje(id, r)
    actuar(f)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
  fin
  robot equipob
  variables
    f, id: numero
  comenzar
    RecibirMensaje(id, r)
    actuar(f)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
  fin
  robot jefe
  variables
    id, totala, f, totalb: numero
  comenzar
    totala:=0
    totalb:=0
    EnviarMensaje(1, r1)  
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4) 
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(f, r1)
        totala:=totala + f
      sino
        si(id = 2)
          RecibirMensaje(f, r2)
          totala:=totala + f
        sino
          si(id = 3)
            RecibirMensaje(f, r3)
            totalb:=totalb + f
          sino
            RecibirMensaje(f, r4)
            totalb:= totalb + f
    si(totala > totalb)
      Informar('gano el primer equipo con', totala)
    sino
      Informar('gano el segundo equipo con', totalb)
  fin
variables
  r1: equipoa
  r2: equipoa
  r3: equipob
  r4: equipob
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r4, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 2,1)
  Iniciar(r2, 3,1)
  Iniciar(r3, 5,1)
  Iniciar(r4, 6,1)
  Iniciar(r, 10,1)
fin
