{MrStore requiere procesar las compras realizadas por sus clientes durante el año 2024.
a) Implementar un módulo que lea compras de productos. De cada compra se lee código del producto, código de cliente, dia y mes. 

La lectura finaliza con el código de cliente 0. Se sugiere utilizar el módulo leerCompra(). 
El módulo debe retornar un vector donde se almacenen las compras agrupadas por mes. 
Las compras de cada mes deben quedar almacenadas en un árbol binario de búsqueda ordenado por código de producto.

b) Implementar un módulo recursivo que reciba el vector generado en a) y retorne el mes con mayor cantidad de compras.

c) Implementar un módulo que reciba el vector generado en al, un número de mes y un código de producto, 
y retorne si fue comprado o no el producto ingresado en el mes recibido.
NOTA: Implementar el programa principal, que invoque a los incisos a, b y с}

program iasd;
type
rango = 1..12;
compras = record
	codigoproducto: integer;
	codigocliente: integer;
	dia: integer;
	mes: rango;
end;

informacion = record
	cliente: integer;
	dia: integer;
end;

lista = ^nodo2;
	nodo2 = record
	dato: informacion;
	sig: lista;
end;

producto = record
	codigo: integer;
	info: lista;
end;

arbol = ^nodo;
	nodo = record
	dato: producto;
	hi, hd: arbol;
end;

vector = array [rango] of arbol;

procedure iniciar(var v: vector);
var
	i: rango;
begin
	for i:=1 to 12 do
	v[i]:=nil;
end;

procedure leer(var c: compras);
begin
	c.codigocliente:=random(200);
	if(c.codigocliente <> 0) then
	begin
		c.dia:=random(30)+1;
		c.mes:=random(12)+1;
		c.codigoproducto:=random(100) + 1000;
	end;
end;

procedure agregaradelante(var l: lista; inf: informacion);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l;
  l := nue;
end;

procedure agregar(var a: arbol; c: compras);
var
	inf: informacion;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=c.codigoproducto;
		a^.dato.info:=nil;
		inf.cliente:=c.codigocliente;
		inf.dia:=c.dia;
		agregarAdelante(a^.dato.info, inf);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(c.codigoproducto < a^.dato.codigo) then
		agregar(a^.hi, c)
	else
	begin
	if(c.codigoproducto > a^.dato.codigo) then
		agregar(a^.hd, c) 
	else
		inf.cliente:=c.codigocliente;
		inf.dia:=c.dia;
		agregarAdelante(a^.dato.info, inf);
	end;
end;


procedure cargar(var v: vector);
var
	c: compras;
begin
	leer(c);
	while(c.codigocliente <> 0) do
	begin
		agregar(v[c.mes], c);
		leer(c);
	end;
end;

function contarlista(l: lista): integer;
begin
	if(l = nil) then
	contarlista:=0
	else
	contarlista:=1 + contarlista(l^.sig);
end;
	

function contararbol(a: arbol): integer;
begin
	if(a = nil) then
	contararbol:=0
	else
	contararbol:=contararbol(a^.hi) + contararbol(a^.hd) + contarlista(a^.dato.info);
end;

 
procedure incisob(v: vector; var max, mesmax: integer; i: integer);
var
	cant: integer;
begin
	if(i<= 12) then
	begin
		cant:=contararbol(v[i]);
		if(cant > max) then
		begin
			max:=cant;
			mesmax:=i;
		end;
		incisob(v, max, mesmax, i+1);
	end;
end;

function buscar(a: arbol; cod: integer): boolean;
begin
	if(a = nil) then
	buscar:=false
	else
	if(a^.dato.codigo = cod) then
	buscar:=true
	else
	if(cod < a^.dato.codigo) then
	buscar(a^.hi, cod) 
	else
	buscar(a^.hd, cod);
end;

function incisoc(v: vector; mes, cod: integer):boolean;
begin
	incisoc:=buscar(v[mes], cod);
end;

var
	v: vector;
	max, mesmax: integer;
	mes, cod: integer;
begin
	iniciar(v);
	cargar(v);

	max:=-1;{b}
	mesmax:=-1;{b}
	incisob(v, max, mesmax, 1);{b}
	write(max, mesmax);{b}
	
	read(mes);
	read(cod);
	if(incisoc(v, mes, cod)) then
	write('se encontro')
	else
	write('no se encontro');
end.
