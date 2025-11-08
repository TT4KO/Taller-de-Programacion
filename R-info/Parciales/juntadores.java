/*Existen dos equipos, Papeleros y Floreros, de dos robots cada uno. El equipo Papeleros sólo junta papeles, y el equipo Floreros sólo junta flores.
El juego consiste en realizar dos cuadrados, y cada cuadrado es realizado por un papelero y un florero de cada equipo, partiendo desde los vértices opuestos:
El primer cuadrado comprende el área entre las esquinas (3,3) y (13,13). El robot florero comienza en la esquina (3,3), y el robot papelero en la (13,13)
El segundo cuadrado comprende el área entre las esquinas (16,3) y (26,13). El robot florero comienza en la esquina (16,3) y el papelero en la (26,13)
Al finalizar el juego, un robot fiscalizador deberá informar qué equipo finalizó primero, y la cantidad total de objetos (flores + papeles) juntados
entre los dos equipos. El robot fiscalizador se ubica en la esquina (14,6).*/

programa ejemplo
procesos
  proceso enviar
  comenzar
    EnviarMensaje(1, r1)
    EnviarMensaje(2, r2)
    EnviarMensaje(3, r3)
    EnviarMensaje(4, r4)
  fin
  proceso juntarflores(ES f: numero)
  comenzar
    si(HayFlorEnLaEsquina)
      tomarFlor
      f:=f + 1
  fin
  proceso moverseflores(ES f: numero)
  comenzar
    repetir 10
      juntarflores(f)
      mover
    derecha
  fin
  proceso juntarpapeles(ES p: numero)
  comenzar
    si(HayPapelEnLaEsquina)
      tomarPapel
      p:=p + 1
  fin
  proceso moversepapeles(ES p: numero)
  comenzar
    repetir 10
      juntarpapeles(p)
      mover
    derecha
  fin
areas
  zona1: AreaP (3,3,13,13)
  zona2: AreaP (16, 3, 26, 13)
  poso: AreaP (14, 6, 14, 6)
robots
  robot equipoa
  variables 
    iniciar: boolean
    f, id: numero
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 4
      moverseflores(f)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
  fin
  robot equipoa2
  variables
    p, id: numero
  comenzar
    RecibirMensaje(id, r)
    p:=0
    repetir 2
      derecha
    repetir 4
      moversepapeles(p)
    EnviarMensaje(id, r)
    EnviarMensaje(p, r)
  fin
  robot equipob 
  variables 
    f, id: numero
  comenzar
    RecibirMensaje(id, r)
    f:=0
    repetir 4
      moverseflores(f)
    EnviarMensaje(id, r)
    EnviarMensaje(f, r)
  fin
  robot equipob2
  variables
    p, id: numero
  comenzar
    RecibirMensaje(id, r)
    p:=0
    repetir 2
      derecha
    repetir 4
      moversepapeles(p)
    EnviarMensaje(id, r)
    EnviarMensaje(p, r)
  fin
  robot jefe
  variables
    id, f1, f2, p1, p2: numero
    totala, totalb, terminoequipoa, terminoequipob: numero
  comenzar
    terminoequipoa:=0
    terminoequipob:=0
    totala:=0
    totalb:=0
    enviar
    repetir 4
      RecibirMensaje(id, *)
      si(id = 1)
        RecibirMensaje(f1, r1)
        totala:=totala + f1
        terminoequipoa:=terminoequipoa + 1
        si(terminoequipoa = 2)
          Informar('el primer equipo termino primero', totala)
      sino  
        si(id = 2)
          RecibirMensaje(p1, r2)
          totala:=totala + p1
          terminoequipoa:=terminoequipoa + 1
          si(terminoequipoa = 2)
            Informar('el primer equipo termino primero con', totala)
        sino
          si(id = 3)
            RecibirMensaje(f2, r3)
            totalb:= totalb + f2
            terminoequipob:= terminoequipob + 1
            si(terminoequipob = 2)
              Informar('el segundo equipo termino primero con', totalb)
          sino
            RecibirMensaje(p2, r4)
            totalb:= totalb + p2
            terminoequipob:= terminoequipob + 1
            si(terminoequipob = 2)
              Informar('el segundo equipo termino primero con', totalb)            
  fin
variables
  r1: equipoa
  r2: equipoa2
  r3: equipob
  r4: equipob2
  r: jefe
comenzar
  AsignarArea(r1, zona1)
  AsignarArea(r2, zona1)
  AsignarArea(r3, zona2)
  AsignarArea(r4, zona2)
  AsignarArea(r, poso)
  Iniciar(r1, 3,3)
  Iniciar(r2, 13,13)
  Iniciar(r3, 16,3)
  Iniciar(r4, 26,13)
  Iniciar(r, 14,6)
fin
