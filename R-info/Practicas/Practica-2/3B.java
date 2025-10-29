programa ejemplo
procesos
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
  proceso movera(ES f: numero)
  comenzar
    repetir 9
      juntar(f)
      mover
  fin
  proceso jungar(ES p: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:= p + 1
  fin
  proceso moverb(ES p: numero)
  comenzar
    repetir 9
      juntar(p)
      mover
  fin
areas
  ciudad: AreaP (1,1,2,40)
  ciudad2: AreaP (3,1,4,40)
robots
  robot equipoa1
  variables
    f: numero
    iniciar: boolean
  comenzar
    f:=0
    movera(f)
    EnviarMensaje(iniciar, a2)
    Pos(1, 21)
    RecibirMensaje(iniciar, a2)
    movera(f)
    EnviarMensaje(iniciar, a2)
    EnviarMensaje(f, a2)
  fin
  robot equipoa2
  variables
    f, f1: numero
    iniciar: boolean
    total: numero
  comenzar
    total:= 0
    f:=0
    RecibirMensaje(iniciar, a1)
    movera(f)
    EnviarMensaje(iniciar, a1)
    Pos(1, 31)
    RecibirMensaje(iniciar, a1)
    movera(f)
    RecibirMensaje(f1, a1)
    total:=f1 + f
    Informar(total)
  fin
  robot equipob1
  variables
    p: numero
    iniciar: boolean
  comenzar
    p:=0
    moverb(p)
    EnviarMensaje(iniciar, b2)
    Pos(3, 21)
    RecibirMensaje(iniciar, b2)
    moverb(p)
    EnviarMensaje(iniciar, b2)
    EnviarMensaje(p, b2)
  fin
  robot equipob2
  variables
    p, p2, total: numero
    iniciar: boolean
  comenzar
    total:= 0
    p:=0
    RecibirMensaje(iniciar, b1)
    moverb(p)
    EnviarMensaje(iniciar, b1)
    Pos(3, 31)
    RecibirMensaje(iniciar, b1)
    moverb(p)
    RecibirMensaje(p2, b1)
    total:=p2 + p
    Informar(total)
  fin
variables
  a1: equipoa1
  a2: equipoa2
  b1: equipob1
  b2: equipob2
comenzar
  AsignarArea(a1, ciudad)
  AsignarArea(a2, ciudad)
  AsignarArea(b1, ciudad2)
  AsignarArea(b2, ciudad2)
  Iniciar(a1, 1,1)
  Iniciar(a2, 1, 11)
  Iniciar(b1, 3, 1)
  Iniciar(b2, 3, 11)
fin    
