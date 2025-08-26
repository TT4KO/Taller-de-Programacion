program iasd;
const
numeromax = 4;
numeromin = 0;
cantactividad = 5;
type
rangoactividad = 1..cantactividad;
asistencia = record
	dia: integer;
	mes: integer;
	numero: integer;
	actividad: rangoactividad;
end;

vector = array [rangoactividad] of integer;

lista = ^nodo;
	nodo = record
	dato: asistencia;
	sig: lista;
end;

procedure leer(var a: asistencia);
begin
	a.numero:=random(numeromax - numeromin + 1) + numeromin;
	if (a.numero <> 0) then
		randomize;
		writeln('ingresa el dia : ');
		readln(a.dia);
		writeln('ingrese el mes : ');
		readln(a.mes);
		writeln('ingrese la actividad : ');
		readln(a.actividad);
end;	
	
procedure Ordenado(var L: lista; a: asistencia);
var
  nue: lista;
  ant,act: lista;
begin
  new(nue);
  nue^.dato:= a;
  ant:= L;
  act:= L;
  While(act <> nil)and(a.numero > act^.dato.numero) do  // > ascendente | < descendente
    begin
      ant:= act;
      act:= act^.sig;
    end;
  { caso 1: va al principio }
  if (ant = nil) then
  begin
    nue^.sig := L;
    L := nue;
  end
  else
  begin
    { caso 2: va en el medio o al final }
    nue^.sig := act;
    ant^.sig := nue;
  end;
end;

procedure cargarlista(var l: lista);
var
	a: asistencia;
begin
	leer(a);
	while(a.numero <> 0) do
	begin
		ordenado(l, a);
		leer(a);
	end;
end;

procedure imprimir(l: lista);
begin
	while(l <> nil) do
	begin
		write('los datos del pasiente fueron : ');
		writeln(l^.dato.dia);
		writeln(l^.dato.mes);
		writeln(l^.dato.numero);
		writeln(l^.dato.actividad);
		l:=l^.sig;
	end;
end;

procedure iniciar(var v: vector);
var
	i: rangoactividad;
begin
	for i:=1 to cantactividad do
	v[i]:=0;
end;

procedure maximo(v: vector; var actmax: integer);
var
	i: rangoactividad;
	max: integer;
begin
	max:=0;
	for i:=1 to cantactividad do
	if (v[i] > max) then
	max:=v[i];
	actmax:= i;
end;

procedure procesar(l: lista);
var
	actual: integer;
	cantidad: integer;
	actmax: integer;
	v: vector;
begin
	iniciar(v);
	actmax:=-1;
	while(l <> nil) do
	begin
		actual:= l^.dato.numero;
		cantidad:=0;
		while(l <> nil) and (l^.dato.numero = actual) do
		begin
			cantidad:=cantidad + 1;
			
			v[l^.dato.actividad]:= v[l^.dato.actividad] + 1;
			
			l:=l^.sig;
		end;	
	write(cantidad);	
	end;
	maximo(v, actmax);
	write(actmax)
end;	

var
l: lista;
begin
	l:=nil;
	cargarlista(l);
	imprimir(l);
	procesar(l);
end.
