/*Dos robots recolectores. A y B, deben coordinarse para recolectar todas las flores de una escalera de 4 escalones, 
comenzando en la esquina (3,3) Cada escalón del robot A tendrá un alto de 4 y un ancho aleatorios entre 2 y 5 esquinas, 
y cada escalón del robot B tendrá un alto de 5 y un ancho aleatorios entre 3 y 6 esquinas. 
El robot A debe realizar un escalón, luego el robot B debe realizar el segundo escalón, 
a su término el robot A hará el tercer escalón y finalmente el robot B completará el cuarto escalón.
Cada vez que un robot completa un escaión, debe depositar de a una las flores en la esquina (1,5), 
y al terminar los dos sus trabajos un robot jefe debe juntar de una sola vez todas las flores recién depositadas
Una vez completada la escalera, el robot jefe debe informar el total en la esquina (1.5)
El robot A inicia en la esquina (2,1), el robot B inicia en la esquina (3,1) y el robot jefe en la esquina (4.1).*/

programa ejemplo 
procesos 
  proceso dejar(ES f: numero)
  variables 
    ca, av: numero
  comenzar 
    ca:=PosCa 
    av:=PosAv 
    BloquearEsquina(1, 10) 
    Pos(1, 10) 
    mientras(f <> 0) 
      depositarFlor f:=f-1 
    Pos(av, ca) 
    LiberarEsquina(1, 10) 
  fin 
  proceso juntar(ES f: numero) 
  comenzar
    si(HayFlorEnLaEsquina) 
      tomarFlor f:=f + 1 
  fin 
  proceso moverse(E cant: numero;ES f: numero;E pasos: numero)
  comenzar 
    repetir pasos
      mover 
      juntar(f) 
    derecha
    repetir cant 
      mover 
      juntar(f) 
    repetir 3 
      derecha 
  fin 
  proceso actuar(E id: numero)
  variables 
    f: numero 
    ok: boolean 
    cant1, cant2, calle, avenida: numero
  comenzar 
    f:=0 
    repetir 2 
      Random(cant1, 2, 4)
      Random(cant2, 3, 5) 
      si(id = 1) 
        moverse(cant1, f, 4) 
        dejar(f) 
        avenida:=PosAv 
        calle:=PosCa 
        EnviarMensaje(avenida, r2)
        EnviarMensaje(calle, r2) 
        EnviarMensaje(ok, r2) 
        RecibirMensaje(avenida, r2) 
        RecibirMensaje(calle, r2) 
        Pos(avenida, calle+1) 
      sino
        RecibirMensaje(avenida, r1)
        RecibirMensaje(calle, r1)
        Pos(avenida, calle+1) 
        RecibirMensaje(ok, r1) 
        moverse(cant2, f, 5) 
        dejar(f) 
        avenida:=PosAv 
        calle:=PosCa
        EnviarMensaje(avenida, r1) 
        EnviarMensaje(calle, r1)
        EnviarMensaje(ok, r1) 
  fin 
areas
  ciudad: AreaC (1,1,100,100) 
robots 
  robot robot1 
  variables 
    ok: boolean 
    id: numero 
  comenzar 
    RecibirMensaje(id, r) 
    si(id = 1) 
      Pos(3, 3) 
    actuar(id) 
    EnviarMensaje(ok, r) 
  fin 
  robot jefe 
  variables 
    f:numero 
    ok: boolean 
  comenzar 
    f:=0 
    EnviarMensaje(1, r1) 
    EnviarMensaje(2, r2) 
    repetir 2 
      RecibirMensaje(ok, *) 
    BloquearEsquina(1, 10) 
    Pos(1, 10) 
    mientras(HayFlorEnLaEsquina)
      tomarFlor 
      f:=f + 1 
    Informar(f) 
  fin 
variables
  r1: robot1 
  r2: robot1 
  r: jefe 
comenzar
  AsignarArea(r1, ciudad) 
  AsignarArea(r2, ciudad) 
  AsignarArea(r, ciudad) 
  Iniciar(r1, 3,1) 
  Iniciar(r2, 4,1) 
  Iniciar(r, 5,1) 
fin
