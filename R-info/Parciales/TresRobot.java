/*Tres robots corren una carrera, en la cual tienen 5 intentos para avanzar una determinada cantidad de pasos. 
En cada intento los robots podrán dar entre 1 y 10 pasos, y deberán juntar todos los papeles que encuentren en cada esquina de su camino. 
Un robot fiscalizador es el encargado de indicarle a cada robot la esquina al azar desde donde deberán comenzar la carrera.
dentro del cuadrante comprendido entre las esquinas (1,1) у (21, 40):
El robot jugador 1 puede tener que empezar su recorrido en una avenida entre 1 y 7.
El robot jugador 2 puede tener que empezar su recorrido en una avenida entre 8 y 14.
El robot jugador 3 puede tener que empezar su recorrido en una avenida entre 15 y 21.
Al finalizar la carrera, los robots jugadores deben depositar en la esquina (1,30) todos los papeles que juntaron, 
y el robot fiscalizador debe informar qué robot dio más pasos. 
Los robots jugadores inician en las esquinas (1,1), (8,1) y (15,1), y el robot fiscalizador en la esquina (25,1).*/

programa ejemplo
procesos
  proceso actualziar(ES max: numero;ES maxid: numero;ES total: numero;ES id: numero)
  comenzar
    si(total > max)
      max:=total
      maxid:=id
  fin
  proceso juntar(ES p: numero)
  comenzar
    mientras(HayPapelEnLaEsquina)
      tomarPapel
      p:=p + 1
  fin
  proceso moverse(E cant: numero; ES p: numero)
  comenzar
    repetir cant
      juntar(p)
      mover
  fin
  proceso dejar(ES p: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(1, 30)
    Pos(1, 30)
    mientras(p <> 0)
      depositarPapel
      p:=p - 1
    Pos(avenida, calle)
    LiberarEsquina(1, 30)
  fin
areas
  ciudad: AreaP (1,1,21, 40)
  zona: AreaP(25, 1, 25, 1)
robots
  robot corredor
  variables
    p, cant, total, id: numero
  comenzar
    RecibirMensaje(id, r)
    p:=0
    repetir 5
      Random(cant, 1, 5)
      total:= total + cant
      moverse(cant, p)
    dejar(p)
    EnviarMensaje(id, r)
    EnviarMensaje(total, r)
  fin
  robot jefe
  variables
    p, total, id, max, maxid: numero
  comenzar
    total:=0
    max:=-1
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    repetir 3
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(total, r1)
        actualziar(max, maxid, total, id)
      sino
        si(id = 2)
          RecibirMensaje(total, r2)
          actualziar(max, maxid, total, id)
        sino
          RecibirMensaje(total, r3)
          actualziar(max, maxid, total, id)
    Informar('ganador', maxid)
  fin
variables
  r1: corredor
  r2: corredor
  r3: corredor
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r3, ciudad)
  AsignarArea(r, zona)
  Iniciar(r1, 1,1)
  Iniciar(r2, 8,1)
  Iniciar(r3, 15,1)
  Iniciar(r, 25, 1)
fin
