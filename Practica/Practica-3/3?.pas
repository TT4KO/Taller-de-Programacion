program ksd;
type
final = record
	codigo: integer;
	fecha: integer;
	nota: integer;
end;

lista = ^nodo;
	nodo = record
	dato: final;
	sig: lista;
end;

alumno = record
	legajo: integer;
	finales: lista;
end;

arbol = ^nodo2;
	nodo2 = record
	dato: alumno;
	hd: arbol;
	hi: arbol;
end;

procedure leer(var legajo: integer; var f: final);
begin
	read(legajo);
	if(legajo <> 0) then
	begin
		read(f.codigo);
		read(f.fecha);
		read(f.nota);
	end;
end;

procedure agregaradelante(var l: lista; f: final);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := f;
  nue^.sig := l;
  l := nue;
end;

procedure agregar(var a: arbol; leg: integer; f: final);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.legajo:=leg;
		a^.dato.finales:=nil;
		agregaradelante(a^.dato.finales, f);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(leg < a^.dato.legajo) then
		agregar(a^.hi, leg, f)
	else
	if(leg > a^.dato.legajo) then
		agregar(a^.hd, leg, f) 
	else
		agregaradelante(a^.dato.finales, f);
end;

procedure cargar(var a: arbol);
var
	f: final;
	leg: integer;
begin
	leer(leg, f);
	while (leg <> 0) do
	begin
		agregar(a, leg, f);
		leer(leg, f);
	end;
end;

function contar(l: lista): integer;
var
	c: integer;
begin
	c:=0;
	while(l <> nil) do
	begin
		if(l^.dato.nota >= 4) then
		c:=c + 1;
		l:=l^.sig;
	end;
	contar:=c;
end;

procedure procesar(a: arbol);
var
	cant: integer;
	aprob: integer;
begin
	cant:=0;
	aprob:=0;
	if (a <> nil) then
	procesar(a^.hi);
	begin
		if (a^.dato.legajo mod 2 = 1) then
		cant:=cant + 1;
		
		aprob:=contar(a^.dato.finales);
		write(a^.dato.legajo, aprob);
		
		procesar(a^.hd);
	end;
	write(cant);
end;
 
var
a: arbol;
begin
	a:=nil;
	cargar(a);
	procesar(a);
end.
