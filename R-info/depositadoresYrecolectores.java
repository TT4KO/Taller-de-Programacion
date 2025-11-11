/* Dos equipos de dos robots cada uno juegan una competencia. En cada equipo hay un robot recolector que junta objetos y un robot depositador que
los debe dejar en cada esquina de la calle asignada al equipo. El primer equipo en llenar su calle con los objetos correspondientes gana el juego. 
Un equipo jugará con flores y el otro con papeles y existen suficientes objetos para jugar. La base del campo de juego se encuentra vacía.
El robot recolector debe juntar un objeto de la fuente del equipo y luego depositarlo en la base del campo de juego, luego el depositador toma 
el objeto de la base y lo deposita en una esquina de la calle hasta completar el recorrido. Un robot fiscalizador es el encargado de decir que 
equipo ganó el juego.*/

programa ejemplo
procesos
  proceso correrflores
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(12, 11)
    Pos(12, 11)
    si(HayFlorEnLaEsquina)
      tomarFlor
    Pos(avenida, calle)
    LiberarEsquina(12, 11)
    si(HayFlorEnLaBolsa)
      depositarFlor
    mover
  fin
  proceso correrpapeles
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(12, 11)
    Pos(12, 11)
    si(HayFlorEnLaEsquina)
      tomarPapel
    Pos(avenida, calle)
    LiberarEsquina(12, 11)
    si(HayPapelEnLaBolsa)
      depositarPapel
    mover
  fin
  proceso juntarflor
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(10, 12)
    Pos(10, 12)
    si(HayFlorEnLaEsquina)
      tomarFlor
    Pos(avenida, calle)
    LiberarEsquina(10, 12)
    BloquearEsquina(12, 11)
    Pos(12, 11)
    si(HayFlorEnLaBolsa)
      depositarFlor
    Pos(avenida, calle)
    LiberarEsquina(12, 11)
  fin
  proceso juntarpapel
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(10, 10)
    Pos(10, 10)
    si(HayPapelEnLaEsquina)
      tomarPapel
    Pos(avenida, calle)
    LiberarEsquina(10, 10)
    BloquearEsquina(12, 11)
    Pos(12, 11)
    si(HayPapelEnLaBolsa)
      depositarPapel
    Pos(avenida, calle)
    LiberarEsquina(12, 11)
  fin
  proceso agarrar(E id: numero)
  variables
    ok: boolean
  comenzar
    si(id = 2)
      juntarflor
      EnviarMensaje(id, r1)
      EnviarMensaje(ok, r1)
    sino
      si(id = 4)
        juntarpapel
        EnviarMensaje(id, r3)
        EnviarMensaje(ok, r3)
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot recolector
  variables
    id, f: numero
  comenzar
    f:=0
    RecibirMensaje(id, r)
    repetir 8
      agarrar(id)
  fin
  robot depositador
  variables
    id: numero
    ok, gane:boolean
  comenzar
    RecibirMensaje(id, r)
    derecha
    mientras(PosAv < 20)
      repetir 2
        RecibirMensaje(id, *)
        si(id = 2)    
          RecibirMensaje(ok, r2)
          correrflores
          si(PosAv = 20)
            EnviarMensaje(id, r)
        sino
          si(id = 4)
            correrpapeles
            RecibirMensaje(ok, r4)
            si(PosAv = 20)
              EnviarMensaje(id, r)
  fin
  robot jefe
  variables
    id: numero
    gane: boolean
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4)
    RecibirMensaje(id, *)
    si(id = 1)
      Informar(id)
    sino
      Informar(id)
  fin
variables
  r1: depositador
  r2: recolector
  r3: depositador
  r4: recolector
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r4, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r, 20,11)
  Iniciar(r1, 12,12)
  Iniciar(r2, 11,12)
  Iniciar(r3, 12,10)
  Iniciar(r4, 11,10)
fin
