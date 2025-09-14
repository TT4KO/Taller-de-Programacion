program iasd;

type 
numero = record
	num: integer;
end;
lista = ^nodo;
	nodo = record
	dato: numero;
	sig: lista;
end;

procedure cargarlista(var l: lista; max: integer; min: integer);
var
	valor: integer;
	nuevonodo: lista;
begin
	randomize;
	repeat
		valor:=random(max - min + 1) + min;
		new(nuevonodo);
		nuevonodo^.dato.num:=valor;
		nuevonodo^.sig:=l;
		l:=nuevonodo;
	until(valor = 5);
end;
	
procedure imprimirlista(l: lista);
begin
	while(l <> nil) do
	begin
		writeln(l^.dato.num:1);
		l:=l^.sig;
	end;
end;

function buscarelemento(l: lista; n:integer):boolean;
Var
	aux:lista;
	encontre:boolean;
Begin
	encontre:= false;
	aux:= l;
	while ((aux <> nil) and (encontre = false)) do
	begin
		if (aux^.dato.num = n) then
		encontre:=true
	else
		aux:= aux^.sig;
end;
	buscarelemento:= encontre;
end;

var
maxn: integer;
minn: integer;
l: lista;	
n: integer;
ok: boolean;
begin
	maxn:=15;
	minn:=0;
	l:=nil;
	cargarlista(l, maxn, minn);
	imprimirlista(l);
	writeln('ingre un valor');
	readln(n);
	ok:= buscarelemento(l, n);
	if (ok = true) then
		write('el numero fue encontrado') 
	else
		write('el numero no existe');
end.
