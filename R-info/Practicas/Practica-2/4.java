programa ejemplo
procesos
  proceso juntar(ES p:numero; ES f: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:= p + 1
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
  proceso recorrerAvenida
  comenzar
    repetir 24
      mover
  fin
areas
  ciudad: AreaC (1,1,100,24)
  area: AreaC(25, 25, 75, 75)
robots
  robot colector
  variables
    p, f: numero
    iniciar: boolean
    rdm: numero
    caller, avenidar, calle, avenida: numero
  comenzar
    calle:= PosCa
    avenida:=PosAv
    p:= 0
    f:= 0  
    repetir 4
      Random(rdm, 25, 75)
      caller:= rdm
      avenidar:=rdm
      RecibirMensaje(iniciar, r)
      recorrerAvenida
      Pos(avenidar, caller)
      juntar(p, f)
      Pos(avenida, calle)    
      EnviarMensaje(p, r)
      EnviarMensaje(f, r)
      EnviarMensaje(iniciar, r)
  fin
  robot jefe
  variables
    totalf, totalp, f1, p1, elegido, max, mejor: numero
    iniciar: boolean
  comenzar  
    totalf:= 0
    totalp:= 0
    max:=-1
    mejor:=0
    repetir 4
      Random(elegido, 1, 3)
      si(elegido = 1)
        EnviarMensaje(iniciar, r1)
      si(elegido = 2)
        EnviarMensaje(iniciar, r2)
      si(elegido = 3)
        EnviarMensaje(iniciar, r3)
      RecibirMensaje(p1, *)
      totalp:=totalp + p1
      RecibirMensaje(f1, *)
      totalf:= totalf + f1
      RecibirMensaje(iniciar, *)
      si(totalf + totalp > max)
        max:=f1
        mejor:= elegido
  fin
variables
  r1: colector
  r2: colector
  r3: colector
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r1, area)
  AsignarArea(r2, ciudad)
  AsignarArea(r2, area)
  AsignarArea(r3, ciudad)
  AsignarArea(r3, area)
  AsignarArea(r, ciudad)
  Iniciar(r1, 25, 1)
  Iniciar(r2, 30, 1)
  Iniciar(r3, 35, 1)
  Iniciar(r, 1,1)
fin
