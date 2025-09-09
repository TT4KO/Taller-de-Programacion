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
	write('legajo: ' );
	read(legajo);
	if(legajo <> 0) then
	begin
		write('codigo: ' );
		read(f.codigo);
		write('fecha: ' );
		read(f.fecha);
		write('nota: ' );
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

function contarimpar(a: arbol): integer;
begin
	if (a = nil) then
	contarimpar:=0
	else
	begin
		if(a^.dato.legajo mod 2 = 1) then
		contarimpar:=1 + contarimpar(a^.hi) + contarimpar(a^.hd)
		else
		contarimpar:=contarimpar(a^.hi) + contarimpar(a^.hd);
	end;
end;
 
function comprobar(l: lista): integer;
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
	comprobar:=c;
end;
 
procedure finalaprobados(a: arbol);
var
	aprobados: integer;
begin
	if(a <> nil) then
	begin
		finalaprobados(a^.hi);
		
		aprobados:=comprobar(a^.dato.finales);
		writeln('legajo: ' , a^.dato.legajo , ' finales aprobados ' , aprobados);
		finalaprobados(a^.hd);
	end;
end;
		
var
a: arbol;
cant: integer;
begin
	a:=nil;
	cargar(a);
	cant:=contarimpar(a);
	writeln('la cantida de legajos impares son: ' , cant);
	finalaprobados(a);
end.
