program ias;
type
comida = record
	nombre: string;
	precio: real;
	calorias: integer;
end;

infocomida = record
	nombre: string;
	precio: real;
end;

lista = ^nodo;
	nodo = record
	dato: infocomida;
	sig: lista;
end;

datocomida = record
	calorias: integer;
	info: lista;
end;

arbol = ^nodo2;
	nodo2 = record
	dato: datocomida;
	hd, hi: arbol;
end;

procedure leer(var c: comida);
begin
	read(c.calorias);
	if(c.calorias <> 0) then
	begin
		read(c.precio);
		read(c.nombre);
	end;
end;

procedure agregaradelante(var l: lista; inf: infocomida);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l;
  l := nue;
end;

procedure agregar(var a:arbol; c: comida);
var
	inf: infocomida;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.calorias:=c.calorias;
		a^.dato.info:=nil;
		inf.nombre:=c.nombre;
		inf.precio:=c.precio;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(a^.dato.calorias = c.calorias) then
	agregaradelante(a^.dato.info, inf)
	else
	if(c.calorias < a^.dato.calorias) then
	agregar(a^.hi, c)
	else
	agregar(a^.hd, c);
end;

procedure cargar(var a: arbol);
var
	c: comida;
begin
	leer(c);
	while(c.calorias <> 0) do
	begin
		agregar(a, c);
		leer(c);
	end;
end;

function calcular(l: lista): integer;
begin
	calcular:=0;
	while(l <> nil) do
	begin
		calcular:=calcular + 1;
		l:=l^.sig;
	end;
end;

function cantidad(a: arbol; min, max: integer):integer;
begin
	if(a = nil) then
	cantidad:=0
	else
	if(a^.dato.calorias < min) then
	if(a^.dato.calorias > max) then
	cantidad:=calcular(a^.dato.info) + cantidad(a^.hi, min, max) + cantidad(a^.hd, min, max)
	else
	cantidad:=cantidad(a^.hi, min, max)
	else
	cantidad:=cantidad(a^.hd, min, max);
end;

var
	a: arbol;
	min, max: integer;
begin
	a:=nil;
	cargar(a);
	read(min);
	read(max);
	write(cantidad(a, min, max));
end.
