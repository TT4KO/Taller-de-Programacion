programa ejemplo
  
areas
  ciudad: AreaP (1,1,1,1)
  ciudadf: AreaPC(9, 9, 9, 13)
  ciudadflor: AreaPC(10, 9, 12, 12)

robots
  robot floreros
  variables
    f, calle, avenida, quien: numero
    iniciar: boolean
  comenzar
    RecibirMensaje(quien, r)
    calle:=PosCa
    avenida:=PosAv
    mientras(f <> 0)
      BloquearEsquina(10, 10)
      Pos(10, 10)
      si(HayFlorEnLaEsquina)
        tomarFlor
        BloquearEsquina(11, 11)
        Pos(11, 11)
        LiberarEsquina(10, 10)
        depositarFlor
        Pos(avenida, calle)
        LiberarEsquina(11, 11)
      sino
        EnviarMensaje(quien, r)
        EnviarMensaje(iniciar, r)
  fin
  robot jefe
  variables
    iniciar: boolean
    f, quien: numero
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    f:= 0
    RecibirMensaje(quien, *)
    si(quien = 1)
      Informar('androide que termino', quien)
    si(quien = 2)
      Informar('androide que termino', quien)  
    si(quien = 3)
      Informar('androide que termino', quien)
    RecibirMensaje(iniciar, *)
    Pos(11, 11)
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:= f +1
    Informar('la cantidad fue', f)
  fin
variables
  r1: floreros
  r2: floreros
  r3: floreros
  r: jefe
comenzar
  AsignarArea(r1, ciudadf)
  AsignarArea(r2, ciudadf)
  AsignarArea(r1, ciudadflor)
  AsignarArea(r2, ciudadflor)
  AsignarArea(r, ciudad)
  AsignarArea(r3, ciudadf)
  AsignarArea(r2, ciudadflor)
  AsignarArea(r3, ciudadflor)
  AsignarArea(r, ciudadflor)
  Iniciar(r, 1,1)
  Iniciar(r1, 9,9)
  Iniciar(r2, 9,10)
  Iniciar(r3, 9,11)
fin
