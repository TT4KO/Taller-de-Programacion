Implementar un módulo recursivo que reciba el vector generado en a) y retorne el mes con mayor cantidad de compras.

function contarLista(l: lista): integer;
begin
  if (l = nil) then 
    contarLista := 0
  else contarLista := 1 + contarLista(l^.sig);
end;
function contarArbol(a: arbol): integer;
begin
  if (a = nil) then 
    contarArbol := 0
  else
    contarArbol := contarLista(a^.dato.detalles) + contarArbol(a^.hi) + contarArbol(a^.hd);
end;
procedure mesMayorCompras(v: vectorMeses; i: integer; var maxMes, maxCant: integer);
var
  cant: integer;
begin
  if (i > 12) then exit;
  cant := contarArbol(v[i]);
  if (cant > maxCant) then begin
    maxCant := cant;
    maxMes := i;
  end;
  mesMayorCompras(v, i+1, maxMes, maxCant);
end;

PP
var
  v: vectorMeses;
  maxMes, maxCant: integer;
begin
  iniciarVector(v);
  cargarVector(v);
  maxCant := -1;
  mesMayorCompras(v, 1, maxMes, maxCant);
  writeln('El mes con mayor cantidad de compras es: ', maxMes);
