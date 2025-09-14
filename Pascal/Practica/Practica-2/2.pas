program idas;
type
lista = ^nodo;
	nodo = record
	dato: integer;
	sig: lista
end;

procedure agregaradelante(var L: lista; num: integer);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dato := num;
  nuevo^.sig := L;
  L := nuevo;
end;

procedure generarlista(var l:lista);
var
	n: integer;
begin
	n:=100 + random(101);
	agregaradelante(l, n);
	if n <> 100 then
	generarlista(l);
end;


procedure mostrarlista(l: lista);
begin
	if(l <> nil) then
	begin
		write('los numero del punto a ' );
		writeln(l^.dato);
		mostrarlista(l^.sig)
	end;
end;

procedure imprimirInverso(L: lista);
begin
  if (L <> nil) then
  begin
    imprimirInverso(L^.sig);  { <-- primero voy más lejos }
    write('los numeros al reves: ');
    writeln(L^.dato);         { al volver, recién imprimo }
  end;
end;

procedure minimo(L: lista);
var
  minResto: integer;
begin
 minresto := 300 ;
  if (L <> nil) then
  begin
    if (L^.dato < minResto) then
      minresto := L^.dato
    else
      minimo(l);
  end;
  writeln('el numero mas chico es: ' , minresto);
end;

function buscarElemento(L: lista; n: integer): boolean;
begin
  if (L = nil) then
    buscarElemento := false                
  else if (L^.dato = n) then
    buscarElemento := true                 
  else
    buscarElemento := buscarElemento(L^.sig, n); 
end;

var 
l: lista;
n: integer;
ok: boolean;
begin
	randomize;
	l:=nil;
	generarlista(l);{a}
	mostrarlista(l);{b}
	imprimirInverso(L);{C}
	minimo(l);{d}
	write('ingrese un numero: ');
	readln(n);
	ok:= buscarelemento(l, n);
	if (ok = true) then
	write('el numero si existe')
	else
	write('suerte la proxima');
end.
