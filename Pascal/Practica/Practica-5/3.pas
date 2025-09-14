program aisd;
type
compra = record
cod : integer;
cliente : integer;
mes : integer;
end;
 
infocodigo = record
	numerocliente: integer;
	mescompra: integer;
end;

lista = ^nodo3;
	nodo3 = record
	dato: infocodigo;
	sig: lista;
end;

videojuego =  record
	codigo: integer;
	info: lista;
end;

arbol = ^nodo;
	nodo = record
	dato: videojuego;
	hi, hd: arbol;
end;

listacompras = ^nodo4;
	nodo4 = record
	dato: infocodigo;
	sig: listacompras;
end;

procedure leercompra (var c : compra);
begin
	c.cliente := Random(200);
	if (c.cod <> 0) then 
	begin
		c.mes := Random(12) + 1;
		c.cod := Random(200) + 1000;
	end;
end;

procedure agregaradelante(var l: lista; inf: infocodigo);
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
	inf: infocodigo;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=c.cod;
		a^.dato.info:=nil;
		inf.numerocliente:=c.cliente;
		inf.mescompra:=c.mes;
		agregaradelante(a^.dato.info, inf);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(a^.dato.codigo < c.cod) then
	agregar(a^.hi, c)
	else
	if(a^.dato.codigo > c.cod) then
	agregar(a^.hd, c)
	else
	begin
		inf.numerocliente:=c.cliente;
		inf.mescompra:=c.mes;
		agregaradelante(a^.dato.info, inf);
	end;
end;
		
	
procedure cargar(var a: arbol);
var
	c: compra;
begin
	leercompra(c);
	while(c.cliente <> 0) do
		begin
		agregar(a, c);
		leerCompra(c);
	end;
end;

procedure crearnuevalista(var l: listacompras; inf: infocodigo);
var
  nue: listacompras;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l;
  l := nue;
end;

procedure nuevalista(l: lista; var l2: listacompras);
begin
	if (l <> nil) then
	begin
		crearnuevalista(l2, l^.dato);
		l:=l^.sig;
	end;
end;

function codigojuego(a: arbol; codgame: integer; var l2: listacompras): listacompras;
begin
	if (a <> nil) then
	begin
		codigojuego:=nil;
		if(a^.dato.codigo = codgame) then
		nuevalista(a^.dato.info, l2);
		codigojuego:=l2
	end
	else
		if(a^.dato.codigo < codgame) then
		codigojuego(a^.hi, codgame, l2)
		else
		codigojuego(a^.hd, codgame, l2);
end;

function comprasrealizadas(l: listacompras; num: integer):integer;
begin
	if(l = nil) then
	comprasrealizadas:=0;
	begin	
		if(l^.dato.mescompra = num) then
		comprasrealizadas:=comprasrealizadas(l^.sig, num) + 1
		else
		comprasrealizadas:=comprasrealizadas(l^.sig, num)		
	end;
end;

var
a: arbol;
codgame: integer;
mesbuscado: integer;
l2: listacompras;
totalcompras: integer;
begin
	l2:=nil;
	a:=nil;
	cargar(a);{a}
	writeln('leer codigo de videojuego');
	read(codgame);{b}
	codigojuego(a, codgame, l2);{b}

	writeln('ingresa un mes: ');{b}
	read(mesbuscado);{b}
	totalcompras:=comprasrealizadas(l2, mesbuscado);
	write('compras por mes son ' , mesbuscado , 'y la cantidad' , totalcompras);
end.
