programa ejemplo
procesos
  proceso juntar(ES f: numero)
  comenzar
    mientras(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso buscar(ES total: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(10, 10)
    Pos(10, 10)
    juntar(total)
    Pos(avenida, calle)
    LiberarEsquina(10, 10)
  fin
  proceso dejar(ES f: numero)
  variables
    calle, avenida: numero
    ok: boolean
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(10, 10)
    Pos(10, 10)
    mientras(HayFlorEnLaBolsa)
      depositarFlor
      f:= f - 1
    Pos(avenida, calle)
    LiberarEsquina(10, 10)
    EnviarMensaje(ok, r)
  fin
  proceso actuar(ES f: numero; ES pasos: numero)
  variables
    ok: boolean
  comenzar
    mientras(f <> 3) & (PosAv < 100) 
      juntar(f)
      mover
      si(PosAv < 100)
        pasos:=pasos + 1
        si(pasos = 15)
          dejar(f)
          pasos:=0
    dejar(f)
  fin
areas
  ciudad: AreaC (1,1,100,100)
robots
  robot colector
  variables
    f: numero
    pasos: numero
    ok: boolean
  comenzar
    pasos:=0
    f:=0
    derecha
    si(PosAv < 100)
      actuar(f, pasos)
    EnviarMensaje(ok, r)
  fin
  robot jefe
  variables
    total, avenida: numero
    ok: boolean
  comenzar  
    total:=0
    repetir 2
      RecibirMensaje(ok, *)
      buscar(total)
    repetir 2
      RecibirMensaje(ok, r)
    Informar(total)
  fin
variables
  r1: colector
  r2: colector
  r: jefe
comenzar
  AsignarArea(r1, ciudad)
  AsignarArea(r2, ciudad)
  AsignarArea(r, ciudad)
  Iniciar(r1, 1,3)
  Iniciar(r2, 1,4)
  Iniciar(r, 1,5)
fin
