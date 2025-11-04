programa ejemplo
procesos
  proceso juntar(ES f: numero; ES corte: boolean; E calle: numero)
  comenzar
    mover
    mientras(HayFlorEnLaEsquina)
      tomarFlor
    mientras(HayFlorEnLaBolsa)
      depositarFlor
      mover
    si(calle = 30)
      corte:= V
    sino
      corte:= F
  fin
  proceso depositar(E cant: numero; E avenida: numero ; ES calle: numero)
  comenzar
    calle:= calle + 1
    BloquearEsquina(avenida, calle)
    Pos(avenida, calle)
    repetir cant
      depositarFlor
    Pos(100, 100)
    LiberarEsquina(avenida, calle)
  fin
areas
  ciudad: AreaC (100,100,100,100)
  zonacliente: AreaP(1, 1, 3, 100)
robots
  robot cliente
  variables
    iniciar, corte: boolean
    cant: numero
    calle, avenida, id, f: numero
  comenzar
    corte:= F
    f:=0
    RecibirMensaje(id, r)
    avenida:=PosAv
    mientras(corte = F) 
      calle:=PosCa
      Random(cant, 1, 4)
      EnviarMensaje(id, r)
      EnviarMensaje(cant, r)
      EnviarMensaje(avenida, r)
      EnviarMensaje(calle, r)
      RecibirMensaje(iniciar, r)
      juntar(f, corte, calle)
    EnviarMensaje(corte, r)
  fin
  robot jefe
  variables
    iniciar, corte: boolean
    calle, avenida, cant, terminaron, id: numero
  comenzar
    terminaron:=0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    mientras(terminaron < 3 )
      RecibirMensaje(id, *)
      RecibirMensaje(cant, *)
      RecibirMensaje(avenida, *)
      RecibirMensaje(calle, *)
      EnviarMensaje(iniciar, r1)
      EnviarMensaje(iniciar, r2)
      EnviarMensaje(iniciar, r3)
      si(cant <> 0)
        depositar(cant, avenida, calle)
        EnviarMensaje(V, *)
      sino
        terminaron:= terminaron + 1
  fin
variables
  r1: cliente
  r2: cliente
  r3: cliente
  r: jefe
comenzar
  AsignarArea(r1, zonacliente)
  AsignarArea(r3, zonacliente)
  AsignarArea(r, ciudad)
  AsignarArea(r, zonacliente)
  AsignarArea(r2, zonacliente)
  Iniciar(r1, 1,1)
  Iniciar(r, 100, 100)
  Iniciar(r2, 2, 1)
  Iniciar(r3, 3, 1)
fin
