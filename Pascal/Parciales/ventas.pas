{de cada venta se conoce: dni de cliente, codigo de sucursal(1..10) numero de factura y monto;
a) implementar un modulo qu elea informacion de las vetnas(la lectua finaliza al ingresar dni de cliente 0) y retorne
	i. Una estructura de datos eficiente para la busqueda por DNI de cliente. 
     Para cada DNI debe almacenarse una lisuta de todas sus compras(numeros y de factura y monto);
	ii. Una estructura de datos que almacene la cantidad de ventas de cada sucursal
b) Realizar un modulo que reciba la estructura generada en el inciso a)i., un monto y un DNI. 
   EL modulo debe retornar la cantidad de facturas cuyo monto es superior al monto ingresado para el DNI ingresado
c) Realizar un modulo recursivo que reciba la estructura generada en inciso a)ii., y retorne el codiugo de sucursal con mayor cantidad de ventas.}

program indas;
type
rango = 1..10;
venta = record
	dni: integer;
	codsuc: rango;
	factura: integer;
	monto: real;
end;

informacion = record
	factura: integer;
	monto: real;
end;

lista = ^nodo;
	nodo = record
	dato: informacion;
	sig: lista;
end;

dnidato = record
	dni: integer;
	info: lista;
end;

arbol = ^nodo2;
	nodo2 = record
	dato: dnidato;
	hi, hd: arbol;
end;

vector = array [rango] of integer;

procedure iniciar(var v: vector);
var
	i: rango;
begin
	for i:=1 to 10 do
	v[i]:=0;
end;

procedure leer(var v: venta);
begin
	write('ingrese dni: ' );
	read(v.dni);
	if(v.dni <> 0) then
	begin
		write('codigo de sucursal: ' );
		read(v.codsuc);
		write('una factura: ' );
		read(v.factura);
		write('un monto: ' );
		read(v.monto);
	end;
end;

procedure agregarAdelante(var l: lista; i: informacion);
var
	nuevo: lista;
begin
	new(nuevo);
	nuevo^.dato:=i;
	nuevo^.sig:=l;
	l:=nuevo;
end;

procedure agregar(var a: arbol; v: venta);
var
	inf: informacion;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.dni:=v.dni;
		a^.dato.info:= nil;
		
		inf.factura:=v.factura;
		inf.monto:=v.monto;
		agregarAdelante(a^.dato.info, inf);
		
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	begin
		if(v.dni < a^.dato.dni) then
			agregar(a^.hi, v) 
		else
		if(v.dni > a^.dato.dni) then
			agregar(a^.hd, v) 
		else
		begin
			inf.factura:=v.factura;
			inf.monto:=v.monto;
			agregarAdelante(a^.dato.info, inf);
		end;
	end;;
end;


procedure cargar(var a: arbol; var vec: vector);
var
	v: venta;
begin
	leer(v);
	while(v.dni <> 0) do
	begin
		agregar(a, v);
		vec[v.codsuc]:=vec[v.codsuc] + 1;
		leer(v);
	end;
end;

procedure imprimirLista(l: lista);
begin
	while(l <> nil) do
	begin
		write('numero deactura y monto del arbol ' , l^.dato.factura, l^.dato.monto);
		l:=l^.sig;
	end;
end;

procedure imprimir(a: arbol);
begin
	if(a <> nil) then
	write('el dni del arbol es: ' , a^.dato.dni);
	imprimirlista(a^.dato.info);
	imprimir(a^.hi);
	imprimir(a^.hd);
end;

function fijarse(l: lista; monto: real): integer;
var
	cant: integer;
begin
	cant:=0;
	while(l <> nil) do
	begin
		if(l^.dato.monto > monto) then
		cant:=cant + 1;
		l:=l^.sig;
	end;
	fijarse:=cant;
end;

function buscar(a: arbol; dnileer: integer; montoleer: real): integer;
begin
	if(a = nil) then
		buscar:=0
	else
	if (dnileer = a^.dato.dni) then
		buscar:= fijarse(a^.dato.info, montoleer)
	else
		if(dnileer < a^.dato.dni) then
		buscar:=buscar(a^.hi, dnileer, montoleer) 
	else
		buscar:=buscar(a^.hd, dnileer, montoleer);
end;

procedure maximo(v: vector; var max, maxcod: integer; i: integer);
begin
	if(i <= 10) then
	begin
		if(v[i] > max) then
		begin
			max:=v[i];
			maxcod:=i;
		end
		else
		maximo(v, max, maxcod, i+1);
end;
end;


var
	a: arbol;
	v: vector;
	dnileer: integer;
	montoleer: real;
	max, maxcod: integer;
begin
	a:=nil;
	iniciar(v);{a}
	cargar(a, v);{a}
	imprimir(a);{a}
	
	write('ingrese un nuevo dni: ' );{b}
	read(dnileer);{b}
	write('ingrese un nuevo monto: ' );{b}
	read(montoleer);{b}
	write('la cantidad del inciso b son: ' , buscar(a, dnileer, montoleer));{b}
	
	max:=-1;{c}
	maxcod:=-1;{c}
	maximo(v, max, maxcod, 1);{c}
end.

