programa ejemplo
procesos
  proceso juntar(ES calle: numero; ES avenida: numero; ES corte: numero)
  comenzar
    repetir 20
      BloquearEsquina(11, 11)
      Pos(11, 11)
      si(HayFlorEnLaEsquina) & (avenida < 20)
        tomarFlor
        Pos(avenida, calle)
        LiberarEsquina(11, 11)
        depositarFlor
        mover
        calle:=calle + 1
      sino
        corte:=corte + 1
  fin
areas
  pista1: AreaP (1,1,1,20)
  pista2: AreaP (2,1,2,20)
  pista3: AreaP (3,1,3,20)
  fijo: AreaP(5, 1, 6, 2)
  poso: AreaPC(11, 11, 12, 12)
robots
  robot corredor
  variables
    calle, avenida, corte, quien: numero
  comenzar
    RecibirMensaje(quien, r)
    corte:= 0
    calle:=PosCa
    avenida:=PosAv
    juntar(calle, avenida, corte)
    si(corta = 1)
      EnviarMensaje(quien, *)
  fin
  robot jefe
  variables
    iniciar: boolean
    quien: numero
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    RecibirMensaje(iniciar, *)
  fin
variables
  r1: corredor
  r2: corredor
  r3: corredor
  r: jefe
comenzar
  AsignarArea(r1, pista1)
  AsignarArea(r, fijo)
  AsignarArea(r2, pista2)
  AsignarArea(r3, pista3)
  AsignarArea(r1, poso)
  AsignarArea(r2, poso)
  AsignarArea(r3, poso)
  Iniciar(r2, 2, 1)
  Iniciar(r, 5,1)
  Iniciar(r1, 1,1)
  Iniciar(r3, 3, 1)
fin
