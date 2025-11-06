programa ejemplo
procesos
  proceso juntarflores(E avenida: numero; E calle: numero)
  variables
    mica, miav: numero
  comenzar
    mica:= PosCa
    miav:= PosAv
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    mientras(HayFlorEnLaEsquina)
      tomarFlor
    Pos(miav, mica)
    LiberarEsquina(avenida, calle)
  fin
  proceso juntarpapeles(E avenida: numero; E calle: numero)
  variables
    mica, miav: numero
  comenzar
    mica:= PosCa
    miav:= PosAv
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    mientras(HayPapelEnLaEsquina)
      tomarPapel
    Pos(miav, mica)
    LiberarEsquina(avenida, calle)
  fin
  proceso basearbolsa(E avenida: numero; E calle: numero)
  variables
    mica, miav: numero
  comenzar
    mica:= PosCa
    miav:= PosAv
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    mientras(HayFlorEnLaBolsa) 
      depositarFlor
    mientras(HayPapelEnLaBolsa)
      depositarPapel
    Pos(miav, mica)
    LiberarEsquina(avenida, calle)
  fin
areas
  ciudad: AreaP (1,1,3,1)
  trabajo: AreaPC(2, 2, 100, 100)
robots
  robot cliente
  variables
    calle, avenida, tarea: numero
  comenzar
    si(tarea <> 4)
      RecibirMensaje(avenida, r)
      RecibirMensaje(calle, r)
      RecibirMensaje(tarea, r)
      si(tarea = 1)
        juntarflores(avenida, calle)
      sino
        si(tarea = 2)
          juntarpapeles(avenida, calle)
        sino
          si(tarea = 3)
            basearbolsa(avenida, calle)
    RecibirMensaje(tarea, r)
  fin
  robot jefe
  variables
    tarea, calle, avenida: numero
    iniciar: boolean
  comenzar
    repetir 3
      Random(avenida, 2, 100)
      Random(calle, 2, 100)
      Random(tarea, 1, 3)
      EnviarMensaje(avenida, r1)
      EnviarMensaje(calle, r1)
      EnviarMensaje(avenida, r2)
      EnviarMensaje(calle, r2)
      si(tarea = 1)
        EnviarMensaje(tarea, r1)
        EnviarMensaje(tarea, r2)
      sino
        si(tarea = 2)
          EnviarMensaje(tarea, r1)
          EnviarMensaje(tarea, r2)
        sino
          EnviarMensaje(tarea, r1)
          EnviarMensaje(tarea, r2)
    tarea:= 4
    EnviarMensaje(tarea, r1)
    EnviarMensaje(tarea, r2)
  fin
variables
  r1: cliente
  r2: cliente
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r, ciudad)
  AsignarArea(r1, trabajo)
  AsignarArea(r2, trabajo)
  Iniciar(r1, 2,1)
  Iniciar(r2, 3,1)
  Iniciar(r, 1,1)
fin
