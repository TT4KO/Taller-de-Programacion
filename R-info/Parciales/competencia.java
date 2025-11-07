/*Se organizó una competencia entre el equipo A y el equipo B. Cada equipo consta
de dos robots que deben realizar por etapas el recorrido de un cuadrado de 10x10
como muestra la figura, recogiendo todas las flores. Cuando un robot de cada
equipo completa su etapa debe:
Avisarle a su compañero para que continúe con la segunda etapa (esto es
solo para el primer robot de cada equipo).
Luego, ambos deben enviar a un robot fiscalizador la cantidad de flores
juntadas y, además,
Deben depositar de a una las flores juntadas en la esquina (20, 20).
Al finalizar la competencia, el robot fiscalizador debe informar la cantidad de
flores del equipo que juntó más flores.
El robot1 del equipo A inicia en (1, 1) y el robot2 en (11, 10). El robot1 del equipo B
inicia en (20, 1) y el robot2 en (31, 10). El robot fiscalizador inicia en (50, 50)*/
programa ejemplo
procesos
  proceso dejarflores(ES f: numero)
  variables
    calle, avenida: numero
  comenzar
    calle:=PosCa
    avenida:=PosAv
    BloquearEsquina(20, 20)
    Pos(20, 20)
    si(f <> 0)
      depositarFlor
    Pos(avenida, calle)
    LiberarEsquina(20, 20)    
  fin
  proceso juntar(ES f: numero)
  comenzar
    si(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso moverse(E cant: numero; ES f: numero)
  comenzar
    repetir cant
      mover
      juntar(f)
    derecha
  fin
areas
  ciudad1: AreaP (1,1,10,10)
  ciudad2: AreaP(20, 1, 29, 10)
  poso: AreaPC (20, 20, 22, 22)
  lider: AreaP(50, 50, 50, 50)
robots
  robot equipoa
  variables
    iniciar: boolean
    f, id: numero
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 2
      moverse(9, f)
    EnviarMensaje(iniciar, r2)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
    dejarflores(f)
  fin
  robot equipoa1
  variables
    f, id: numero
    iniciar: boolean
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 2
      derecha
    RecibirMensaje(iniciar, r1)
    repetir 2
      moverse(8, f)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
    dejarflores(f)
  fin
  robot equipob
  variables
    iniciar: boolean
    f, id: numero
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 2
      moverse(9, f)
    EnviarMensaje(iniciar, r4)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
    dejarflores(f)
  fin
  robot equipob2
  variables
    f, id: numero
    iniciar: boolean
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 2
      derecha
    RecibirMensaje(iniciar, r3)
    repetir 2
      moverse(8, f)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
    dejarflores(f)
  fin
  robot jefe
  variables
    totala, totalb, id, f: numero
  comenzar
    totala:=0
    totalb:=0
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4)
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(f, r1)
        totala:=totala + f
      sino
        si(id = 2)
          RecibirMensaje(f, r2)
          totala:=totala + f
        sino
          si(id = 3)
            RecibirMensaje(f, r3)
            totalb:=totalb + f
          sino
            RecibirMensaje(f, r4)
            totalb:=totalb + f
    si(totala > totalb)
      Informar('el equipo a gano con un total de', totala)
    sino
      Informar('el equipo b gano con un total de', totalb)
  fin
variables
  r1: equipoa
  r2: equipoa1
  r3: equipob
  r4: equipob2
  r: jefe
comenzar
  AsignarArea(r1, ciudad1)
  AsignarArea(r2, ciudad1)
  AsignarArea(r3, ciudad2)
  AsignarArea(r4, ciudad2)
  AsignarArea(r1, poso)
  AsignarArea(r2, poso)
  AsignarArea(r3, poso)
  AsignarArea(r4, poso)
  AsignarArea(r, lider)
  Iniciar(r1, 1,1)
  Iniciar(r3, 20, 1)
  Iniciar(r4, 29, 9)
  Iniciar(r, 50, 50)
  Iniciar(r2, 10, 9)
fin
