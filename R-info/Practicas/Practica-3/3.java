programa ejemplo
procesos
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:= f + 1
  fin
areas
  ciudad: AreaC (2,2,10,10)
  ciudadjefe: AreaP(1, 1, 1, 1)
  espera: AreaPC(2, 1, 10, 2)
robots
  robot floreros
  variables
    iniciar: boolean
    altura, ancho, quien, calle, avenida, f: numero
  comenzar
    f:= 0
    repetir 3
      calle:=PosCa
      avenida:=PosAv
      RecibirMensaje(quien, r)
      RecibirMensaje(altura, r)
      RecibirMensaje(ancho, r)
      BloquearEsquina(altura, ancho)
      Pos(altura, ancho)
      juntar(f)
      Pos(avenida, calle)
      LiberarEsquina(altura, ancho)
    EnviarMensaje(quien, r)
    EnviarMensaje(f, r)
  fin
  robot jefe
  variables
    rdm: numero
    iniciar: boolean
    max, rmax, quien, f: numero
  comenzar
    max:=0
    repetir 3
      Random(rdm, 2, 10)
      EnviarMensaje(1, r1)
      EnviarMensaje(rdm, r1)
      EnviarMensaje(rdm, r1) 
      EnviarMensaje(2, r2)
      EnviarMensaje(rdm, r2)
      EnviarMensaje(rdm, r2)
      EnviarMensaje(3, r3)
      EnviarMensaje(rdm, r3)
      EnviarMensaje(rdm, r3)
    repetir 3
      RecibirMensaje(quien, *)  
      si(quien = 1)
        RecibirMensaje(f, r1)
      si(quien = 2)
        RecibirMensaje(f, r2)
      si(quien = 3)
        RecibirMensaje(f, r3)
      si(f> max)
        max:= f
        rmax:= quien
    Informar(rmax)
  fin
variables
  r1: floreros
  r2: floreros
  r3: floreros
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r, ciudadjefe)
  AsignarArea(r1, espera)
  AsignarArea(r2, espera)
  AsignarArea(r3, espera)
  Iniciar(r1, 2,1)
  Iniciar(r2, 3,1)
  Iniciar(r3, 4,1)
  Iniciar(r, 1,1)
fin
