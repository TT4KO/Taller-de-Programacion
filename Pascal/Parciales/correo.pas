{El Correo Argentino necesita procesar los envíos entregados durante el mes de Julio de 2024. 
De cada envío se conoce el código del cliente, día, código postal y peso del paquete.
 
A) Implementar un módulo que lea envíos, genere y retorne un árbol binario de búsqueda ordenado por código postal, 
donde para cada código postal se almacenen en una lista todos los envíos (código de cliente, día y peso del paquete) correspondientes. 
La lectura finaliza con código de cliente 0.

B) Implementar un módulo que reciba la estructura generada en a) y un código postal, y retorne todos los envíos de dicho código postal.

C) Realizar un módulo recursivo que reciba la estructura que retorna el inciso b) 
y retorne los dos códigos de cliente correspondientes al envío con mayor y menor peso.
}

program ias;
type
envio = record
	codigocliente: integer;
	codigopostal: integer;
	dia: integer;
	peso: real;
end;

informacion = record
	codigo: integer;
	dia: integer;
	peso: real;
end;

lista = ^nodo;
	nodo = record
	dato: informacion;
	sig: lista;
end;

envioarbol = record
	postal: integer;
	info: lista;
end;

arbol = ^nodo2;
	nodo2 = record
	dato: envioarbol;
	hd, hi: arbol;
end;

procedure leer(var e: envio);
begin
	read(e.codigocliente);
	if(e.codigocliente <> 0) then
	begin
		read(e.codigopostal);
		read(e.dia);
		read(e.peso);
	end;
end;

procedure agregaradelante(var l: lista; i: informacion);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:=i;
	nue^.sig:=l;
	l:=nue;
end;

procedure agregar(var a: arbol; e: envio);
var
	inf: informacion;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.postal:=e.codigopostal;
		a^.dato.info:=nil;
		
		inf.codigo:=e.codigocliente;
		inf.dia:=e.dia;
		inf.peso:=e.peso;
		agregaradelante(a^.dato.info, inf);
		
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	begin
	if(e.codigopostal < a^.dato.postal) then
		agregar(a^.hi, e);
	if(e.codigopostal > a^.dato.postal) then
		agregar(a^.hd, e)
	else
	begin
		inf.codigo:=e.codigocliente;
		inf.dia:=e.dia;
		inf.peso:=e.peso;
		agregaradelante(a^.dato.info, inf);
	end;
	end;
end;

procedure cargar(var a: arbol);
var
	e: envio;
begin
	leer(e);
	while(e.codigocliente <> 0) do
	begin
		agregar(a, e);
		leer(e);
	end;
end;

procedure mostrarenvios(l: lista);
begin
	while(l <> nil) do
	begin
		write(l^.dato.codigo , l^.dato.dia , l^.dato.peso);
		l:=l^.sig;
	end;
end;

procedure incisob(a: arbol; cod: integer);
begin
	if(a = nil) then
	write('no se encontro el codigo postal')
	else
	if(cod = a^.dato.postal) then
	begin
		write('envios del codigo postal' , cod , ' : ');
		mostrarenvios(a^.dato.info);
	end
	else
	if(cod < a^.dato.postal) then
	incisob(a^.hi, cod)
	else
	incisob(a^.hd, cod)
end;

procedure incisoc(l: lista; minpeso, maxpeso: real; mincod, maxcod: integer);
begin
	if(l <> nil) then
	begin
		minpeso:= l^.dato.peso;
		maxpeso:=l^.dato.peso;
		mincod:=l^.dato.codigo;
		maxcod:=l^.dato.codigo;
	end
	else
	begin
	if(l^.dato.peso < minpeso) then
	begin
		minpeso:=l^.dato.peso;
		mincod:=l^.dato.codigo;
	end;
	if(l^.dato.peso > minpeso) then
	begin
		maxpeso:=l^.dato.peso;
		maxcod:=l^.dato.codigo
	end;
	incisoc(l^.sig, minpeso, maxpeso, mincod, maxcod);
end;
end;

var
	a:arbol;
	cod: integer;
	minpeso, maxpeso: real;
	mincod, maxcod: integer;
	l: lista;
begin
	l:=nil;
	a:=nil;
	cargar(a);{a}
	
	read(cod);{b}
	incisob(a, cod);{b}
	
	mincod:=9999;
	minpeso:=9999;
	maxpeso:=-1;
	maxcod:=-1;
	
	incisoc(l, minpeso, maxpeso, mincod, maxcod)
end.
