/*Tres robots floreros tienen 8 intentos en total para juntar todas las flores dentro del cuadrante comprendido entre las esquinas (40,40) y (60,60). 
Para ello, en cada intento un robot fiscalizador indicará a un robot aleatorio la esquina a la que debe dirigirse. 
El fiscalizador calculará esta esquina de manera aleatoria.
Al completarse los 8 intentos, los robots floreros deberán depositar todas las flores juntadas en la esquina (10,10), y el robot 
  fiscalizador deberá informar la cantidad total de flores juntadas por los robots.
Los robots floreros inician en las esquinas (1,1), (2,1) y (3,1) respectivamente, y el fiscalizador en la (4,1).*/

programa ejemplo
procesos
  proceso juntar(ES f: numero; E avenida:numero; E calle: numero)
  variables
    mica, miav: numero
  comenzar
    mica:=PosCa
    miav:=PosAv
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
    Pos(miav, mica)
    LiberarEsquina(avenida, calle)
  fin
  proceso dejar(ES f: numero)
  variables
    mica, miav: numero
  comenzar
    mica:=PosCa
    miav:=PosAv
    BloquearEsquina(10, 10)
    Pos(10, 10)
    mientras(f <> 0)
      depositarFlor
      f:=f - 1
    Pos(miav, mica)
    LiberarEsquina(10, 10)
  fin
  proceso enviarID
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
  fin
  proceso asignarLugar
  variables
    lugar1, lugar2: numero
  comenzar  
    Random(lugar1, 40, 60)
    Random(lugar2, 40, 60)
    EnviarMensaje(lugar1, r1)
    EnviarMensaje(lugar2, r1)
    Random(lugar1, 40, 60)
    Random(lugar2, 40, 60)
    EnviarMensaje(lugar1, r2)
    EnviarMensaje(lugar2, r2)
    Random(lugar1, 40, 60)
    Random(lugar2, 40, 60)
    EnviarMensaje(lugar1, r3)
    EnviarMensaje(lugar2, r3)
  fin
  proceso actuar(ES total: numero)
  comenzar
    BloquearEsquina(10, 10)
    Pos(10, 10)
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      total:=total + 1
  fin
areas
  ciudad: AreaC (1,1,4,1)
  trabajo: AreaPC(40, 40, 60, 60)
  poso: AreaPC(10, 10, 10, 10)
robots
  robot pro
  variables
    calle, id, avenida, f: numero
    ok: boolean
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 3
      RecibirMensaje(avenida, r)
      RecibirMensaje(calle, r)
      juntar(f, avenida, calle)
    dejar(f)
    EnviarMensaje(ok, r)
  fin
  robot jefe
  variables
    id, lugar1, lugar2, total: numero
    ok: boolean
  comenzar
    total:=0
    enviarID
    repetir 3
      asignarLugar
    repetir 3
      RecibirMensaje(ok, *)
    actuar(total)
    Informar(total)
  fin
variables
  r1: pro
  r2: pro
  r3: pro
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r1, trabajo)
  AsignarArea(r2, trabajo)
  AsignarArea(r3, trabajo)
  AsignarArea(r1, poso)
  AsignarArea(r2, poso)
  AsignarArea(r3, poso)
  AsignarArea(r, poso)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 2,1)
  Iniciar(r3, 3,1)
  Iniciar(r, 4,1)
fin
