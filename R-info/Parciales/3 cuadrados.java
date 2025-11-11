/*Tres robots recolectores deben realizar 3 cuadrados cada uno, como se ejemplifica en la figura, juntando todas las flores que encuentran a su paso. 
  Inicialmente, un robot coordinador deberá informar a cada recolector el tamaño de los cuadrados a realizar (calculado aleatoriamente entre 1 y 6). 
  Al completar cada cuadrado, los recolectores deberán depositar de a una en la esquina (50,50) fas flores encontradas y 
  luego avisar al coordinador para que recoja las flores recién depositadas. Una vez que todos los recolectores completaron sus tareas, 
  el coordinador deberá informar cuál fue el que recolectó más flores. Los recolectores inician en las esquinas (1,1) y (10,1), (20,1) y
  el coordinador en la esquina (100,100).*/
programa ejemplo
procesos
  proceso buscar(ES f: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(50, 50)
    Pos(50, 50)
    mientras(HayFlorEnLaEsquina)
      mientras(f <> 0)
        tomarFlor
        f:=f-1
    Pos(avenida, calle)
    LiberarEsquina(50, 50)
  fin
  proceso procesar(E id:numero; ES f: numero)
  comenzar
    repetir 2
      si(id = 1)
        RecibirMensaje(f, r1)
        buscar(f)
      sino
        RecibirMensaje(f, r2)
        buscar(f)
  fin
  proceso dejar(ES f: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(50, 50)
    Pos(50, 50)
    mientras(f <> 0)
      depositarFlor
      f:=f - 1
    Pos(avenida, calle)
    LiberarEsquina(50, 50)
  fin
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso actuar(ES f: numero; E num: numero; ES total: numero)
  comenzar
    repetir 4
      repetir num
        juntar(f)
        mover
      derecha
    total:=total + 1
    Pos(PosAv, PosCa+(num+1))
  fin
  proceso ganador(ES id: numero; ES cant: numero; ES maxid: numero; ES max: numero)
  comenzar
    si(cant > max)
      max:=cant
      maxid:=id
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot blit
  variables
    f, num, id, total: numero
    ok: boolean
  comenzar
    f:=0
    total:=0
    RecibirMensaje(id, r)
    RecibirMensaje(num, r)
    repetir 3
      actuar(f, num, total) 
      EnviarMensaje(id, r)
      EnviarMensaje(f, r) 
      dejar(f)
    EnviarMensaje(id, r)
    EnviarMensaje(total, r)
  fin
  robot jefe
  variables
    num, maxid, max, total f, id: numero
    ok: boolean
  comenzar
    max:=-1
    total:=0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    Random(num, 1, 6)
    EnviarMensaje(num, r1)
    Random(num, 1, 6)
    EnviarMensaje(num, r2)
    repetir 3
      RecibirMensaje(id, *)
      procesar(id, f)
    repetir 2
      RecibirMensaje(total, *)
      si(id = 1)
        RecibirMensaje(total, r1)
        ganador(id, total, maxid, max)
      sino
        RecibirMensaje(total, r2)
        ganador(id, total, maxid, max)
    Informar(maxid)
  fin
variables
  r1: blit
  r2: blit
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,1)
  Iniciar(r2, 10,1)
  Iniciar(r, 100,100)
fin
