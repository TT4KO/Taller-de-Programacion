program iajsd;
type
rango = 'A'..'F';
atencion = record
	matricula: integer;
	dni: integer;
	dia: integer;
	diagnostico: rango;
end;

medico = record
	matricula2: integer;
	cantidad: integer;
end;

arbol = ^nodo;
	nodo =  record
	dato: medico;
	hi, hd: arbol;
end;

lista = ^nodo2;
	nodo2 = record
	dato: integer;
	sig: lista;
end;

vector = array [rango] of lista;

procedure iniciar(var v: vector);
var
	i: rango;
begin
	for i:='A' to 'F' do
	v[i]:=nil;
end;

procedure leer(var a: atencion);
var
	v: array [1..6] of char = ('A', 'B', 'C', 'D', 'E', 'F');
begin
	a.dni:=random(5000);
	if(a.dni <> 0) then
	begin
		a.matricula:=random(1000)+2000;
		a.dia:=random(31)+1;
		a.diagnostico:=v[random(6)+1];
	end;
end;


procedure agregar(var a:arbol; at: atencion);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.matricula2:=at.matricula;
		a^.dato.cantidad:=1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(a^.dato.matricula2 = at.matricula) then
		a^.dato.cantidad:=a^.dato.cantidad + 1
	else
	if(at.matricula < a^.dato.matricula2) then
		agregar(a^.hi, at)
	else
		agregar(a^.hd, at);
end;


procedure adelante(var l: lista; dni: integer);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dato := dni;
  nuevo^.sig := l;
  l := nuevo;
end;


procedure cargar(var a: arbol; var v: vector);
var
	at: atencion;
begin
	leer(at);
	while(at.dni <> 0) do
	begin
		agregar(a, at);
		adelante(v[at.diagnostico], at.dni);
		leer(at);
	end;
end;

function puntob(a: arbol; num: integer): integer;
begin
	if(a = nil) then
	puntob:=0
	else
	if(a^.dato.matricula2 > num) then
		puntob:=a^.dato.cantidad + puntob(a^.hi, num) + puntob(a^.hd, num)
	else
		puntob:=puntob(a^.hd, num);
end;

function recorrer(l: lista): integer;
begin
	if(l = nil) then
		recorrer:=0
	else
		recorrer:=recorrer(l^.sig) + 1;
end;

procedure puntoc(v: vector; var max: integer; var diagmax: rango; diag: rango);
var
	cant: integer;
begin
	if diag <= 'F' then
		cant:=recorrer(v[diag]);
		if(cant > max) then
			begin
		max:=cant;
			diagmax:=diag;
	end;
	puntoc(v, max, diagmax, succ(diag));
end;

var
	a: arbol;
	v: vector;
	matri: integer;
	max: integer;
	diagmax: rango;
begin
	max:=-1;
	diagmax:='A';
	a:=nil;
	iniciar(v);
	cargar(a, v);
	
	read(matri);
	puntob(a, matri);
	write(puntob(a, matri));
	puntoc(v, max, diagmax, 'A');
	write(diagmax);
end.
