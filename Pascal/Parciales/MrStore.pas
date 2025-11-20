{MrStore requiere procesar las compras realizadas por sus clientes durante el año 2024.
a) Implementar un módulo que lea compras de productos. De cada compra se lee código del producto, código de cliente, dia y mes. 

La lectura finaliza con el código de cliente 0. Se sugiere utilizar el módulo leerCompra(). 
El módulo debe retornar un vector donde se almacenen las compras agrupadas por mes. 
Las compras de cada mes deben quedar almacenadas en un árbol binario de búsqueda ordenado por código de producto.

b) Implementar un módulo recursivo que reciba el vector generado en a) y retorne el mes con mayor cantidad de compras.

c) Implementar un módulo que reciba el vector generado en al, un número de mes y un código de producto, 
y retorne si fue comprado o no el producto ingresado en el mes recibido.
NOTA: Implementar el programa principal, que invoque a los incisos a, b y с}

program iajsd;
type
rango = 1..12;
compra = record
	codigo: integer;
	cliente: integer;
	dia: integer;
	mes: rango;
end;

arbol = ^nodo;
	nodo = record
	dato: compra;
	hi, hd: arbol;
end;

vector = array [rango] of arbol;

procedure iniciar(var v: vector);
var
	i: integer;
begin
	for i:=1 to 12 do
	v[i]:=nil;
end;

procedure leer(var c: compra);
begin
	read(c.cliente);
	if(c.cliente <> 0) then
	begin
		read(c.codigo);
		read(c.dia);
		read(c.mes);
	end;
end;

procedure agregar(var a: arbol; c: compra);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato:=c;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(c.codigo < a^.dato.codigo) then
		agregar(a^.hi, c) 
	else
		agregar(a^.hd, c);
end;

procedure cargar(var v: vector);
var
	c: compra;
begin
	leer(c);
	while(c.cliente <> 0) do
	begin
		agregar(v[c.mes], c);
		leer(c);
	end;
end;

procedure fijarse(a: arbol; var cant: integer);
begin
	if(a <> nil) then
	begin
	fijarse(a^.hi, cant);
		cant:=cant + 1;
	fijarse(a^.hd, cant);
	end;
end;

procedure puntob(v: vector; var max, mesmax: integer; i: integer);
var
	cant: integer;
begin
	cant:=0;
	if (i <= 12) then
	begin
	fijarse(v[i], cant);
	if(cant > max) then
	begin
		max:=cant;
		mesmax:=i;
	end;
	puntob(v, max, mesmax, i+1);
end;
end;

function encontrado(a: arbol; cod: integer): boolean;
begin
	if(a = nil) then
	encontrado:=false
	else
	if(a^.dato.codigo = cod) then
		encontrado:=true
	else
	if(cod < a^.dato.codigo) then
		encontrado(a^.hi, cod)
	else
		encontrado(a^.hd, cod);
end;

function puntoc(v: vector; num, cod: integer): boolean;
begin
	puntoc:=false;
	if (encontrado(v[num], cod)) then
	puntoc:=true;
end; 

var
	v: vector;
	max, mesmax: integer;
	mesleer, cod: integer;
begin
	iniciar(v);
	cargar(v);
	max:=-1;
	puntob(v, max, mesmax, 1);
	read(mesleer);
	read(cod);
	if(puntoc(v, mesleer, cod)) then
		write('se encontro')
		else
		write('no encontrado');
end.
