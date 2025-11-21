{El Correo Argentino necesita procesar los envíos entregados durante el mes de Julio de 2024. 
De cada envío se conoce el código del cliente, día, código postal y peso del paquete.
 
A) Implementar un módulo que lea envíos, genere y retorne un árbol binario de búsqueda ordenado por código postal, 
donde para cada código postal se almacenen en una lista todos los envíos (código de cliente, día y peso del paquete) correspondientes. 
La lectura finaliza con código de cliente 0.

B) Implementar un módulo que reciba la estructura generada en a) y un código postal, y retorne todos los envíos de dicho código postal.

C) Realizar un módulo recursivo que reciba la estructura que retorna el inciso b) 
y retorne los dos códigos de cliente correspondientes al envío con mayor y menor peso.
}

program iajsd;
type
envio = record
	cliente: integer;
	dia: integer;
	postal: integer;
	peso: real;
end;

informacion = record
	dia2: integer;
	peso2: real;
	cliente2: integer;
end;

lista = ^nodo;
	nodo = record
	dato: informacion;
	sig: lista;
end;

codigo = record
	postal2: integer;
	info: lista;
end;

lista2 = ^nodo3;
	nodo3 = record
	dato: informacion;
	sig: lista2;
end;
arbol = ^nodo2;
	nodo2 = record
	dato: codigo;
	hi, hd: arbol;
end;

procedure leer(var e: envio);
begin
	read(e.cliente);
	if(e.cliente <> 0) then
	begin
		read(e.dia);
		read(e.postal);
		read(e.peso);
	end;
end;

procedure adelante(var l: lista; i: informacion);
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
		a^.dato.postal2:=e.postal;
		a^.dato.info:=nil;
		inf.dia2:=e.dia;
		inf.peso2:=e.peso;
		inf.cliente2:=e.cliente;
		adelante(a^.dato.info, inf);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(e.postal < a^.dato.postal2) then
		agregar(a^.hi, e)
	else
	if(e.postal > a^.dato.postal2) then
		agregar(a^.hd, e)
	else
	begin
		inf.dia2:=e.dia;
		inf.peso2:=e.peso;
		inf.cliente2:=e.cliente;
		adelante(a^.dato.info, inf);
	end;
end;

procedure cargar(var a: arbol);
var
	e: envio;
begin
	leer(e);
	while(e.cliente <> 0) do
	begin
		agregar(a, e);
		leer(e);
	end;
end;

procedure agregardelante(var l: lista2; i: informacion);
var
	nue: lista2;
begin
	new(nue);
	nue^.dato:=i;
	nue^.sig:=l;
	l:=nue;
end;

procedure insertar(l: lista; var l2: lista2);
begin
	while(l <> nil) do
	begin
		agregardelante(l2, l^.dato);
		l:=l^.sig;
	end;
end;

procedure puntob(a: arbol; var l: lista2; cod: integer);
begin
	if(a <> nil) then
	begin
		if(cod < a^.dato.postal2) then
			puntob(a^.hi, l, cod)
		else
		if(cod > a^.dato.postal2) then
			puntob(a^.hd, l, cod)
		else
			insertar(a^.dato.info, l);
		end;
end;

procedure puntoc(l: lista2; var codmin, codmax: integer; var min, max: real);
begin
	if(l <> nil) then
	begin
		if(l^.dato.peso2 > max) then
		begin
			max:=l^.dato.peso2;
			codmax:=l^.dato.cliente2;
		end;
		if(l^.dato.peso2 < min) then
		begin
			min:=l^.dato.peso2;
			codmin:=l^.dato.cliente2;
		end;
		puntoc(l^.sig, codmin, codmax, min, max);
	end;
end;


var
	a: arbol;
	l2: lista2;
	cod: integer;
	codmin, codmax: integer;
	min, max: real;
begin
	a:=nil;
	l2:=nil;
	min:=9999;
	max:=-1;
	cargar(a);
	read(cod);
	puntob(a, l2, cod);
	puntoc(l2, codmin, codmax, min, max);
	write(codmin, codmax);
end.
