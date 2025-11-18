{un comercio necesita el procesamiento de las compras realizada por sus clientes durante el mes de julio 2022. De cada compra se conoce codigo del cliente,
dia, cantidad de productos y monto pagado. 
a)Implementar un modulo que lea compras, gener y retorne una estrucuta adecuada para la busqueda por codigo del cliente, donde para cada codigo de cliente
se almacenan juntas todas sus compras(dia, cantidad de productos y monto) que realizo. La lectura finaliza con cantidad de productos 0. Se sugiere utilizar
el modulo "leerregistro".
b)implementar un modulo que reciba la estrucuta generada en a) y un codigo de cliente y retorne todas las compras de dicho cliente.
c)Realizar uin modulo recursivo que reciba la estructura que retorna en inciso b) y retorne el monto de la ocmpra con mayor cantidad de productos}

program iajsd;
type
compra = record
	codigo: integer;
	dia: integer;
	cant: integer;
	monto: real
end;

informacion = record
	dia2: integer;
	cant2: integer;
	monto2: real;
end;

lista2 = ^nodo3;
	nodo3 = record
	dato: informacion;
	sig: lista2;
end;

lista = ^nodo;
	nodo = record
	dato: informacion;
	sig: lista;
end;

cliente = record
	codigo2: integer;
	info: lista;
end;

arbol = ^nodo2;
	nodo2 = record
	dato: cliente;
	hi, hd: arbol;
end;

procedure leer(var c: compra);
begin
	read(c.cant);
	if (c.cant <>0) then
	begin
		read(c.codigo);
		read(c.dia);
		read(c.monto);
	end;
end;

procedure adelante(var l: lista; inf: informacion);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l;
  l := nue;
end;

procedure agregar(var a: arbol; c: compra);
var
	inf: informacion;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo2:=c.codigo;
		a^.dato.info:=nil;
		inf.dia2:=c.dia;
		inf.cant2:=c.cant;
		inf.monto2:=c.monto;
		adelante(a^.dato.info, inf);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(c.codigo < a^.dato.codigo2) then
		agregar(a^.hi, c)
	else
	if(c.codigo > a^.dato.codigo2) then 
		agregar(a^.hd, c)
	else
	begin
		inf.dia2:=c.dia;
		inf.cant2:=c.cant;
		inf.monto2:=c.monto;
		adelante(a^.dato.info, inf);
	end;
end;

procedure cargar(var a: arbol);
var
	c: compra;
begin
	leer(c);
	while(c.cant <> 0) do
	begin
		agregar(a, c);
		leer(c);
	end;
end;

procedure agregaradelante(inf: informacion; var l2: lista2);
var
  nue: lista2;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l2;
  l2 := nue;
end;

procedure insertar(l: lista; var l2: lista2);
begin
	while(l <> nil) do
	begin
		agregaradelante(l^.dato, l2);
		l:=l^.sig;
	end;
end;

function puntob(a: arbol; cod: integer; var l: lista2): integer;
begin
	if(a =  nil) then
		puntob:=0
	else
	if (a^.dato.codigo2 < cod) then
		puntob(a^.hi, cod, l)
	else
		if (a^.dato.codigo2 > cod) then
		puntob(a^.hd, cod, l)
	else
		insertar(a^.dato.info, l);
end;

function puntoc(l: lista2; var max, maxcant: real): real;
begin
	if(l = nil) then
	puntoc:=maxcant
	else
	begin
	if(l^.dato.cant2 > max) then
	begin
		max:=l^.dato.cant2;
		maxcant:=l^.dato.monto2;
	end;
		puntoc:=puntoc(l^.sig, max, maxcant);
	end;
end;

var
	a: arbol;
	cod: integer;
	l2: lista2;
	max, maxcant: real;
begin
	max:=-1;
	l2:=nil;
	a:=nil;
	cargar(a);
	read(cod);
	puntob(a, cod, l2);
	puntoc(l2, max, maxcant);
	write(puntoc(l2, max, maxcant));
end.
