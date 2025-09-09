program iasdj;
type
paquete = record
	codigo: integer;
	dniemisor: integer;
	dnireceptor: integer;
	paquetes: integer;
	peso: integer;
end;

arbol = ^nodo;
	nodo = record
	dato: paquete;
	hd: arbol;
	hi: arbol;
end;

lista = ^nodo2;
	nodo2 = record
	dato: paquete;
	sig: lista;
end;

procedure leer(var p: paquete);
begin
	write('codigo: ' );
	read(p.codigo);
	if(p.codigo <> 0) then
	begin
		write('dni emisor: ' );
		read(p.dniemisor);
		write('dni receptor: ' );
		read(p.dnireceptor);
		write('paquetes: ' );
		read(p.paquetes);
		write('peso: ' );
		read(p.peso);
	end;
end;

procedure cargar(var a: arbol; p: paquete);
begin
	if(a = nil) then
	begin
	new(a);
	a^.dato:=p;
	a^.hi:=nil;
	a^.hd:=nil;
	end
	else
	if (p.peso < a^.dato.peso) then
		cargar(a^.hi, p)
	else
		cargar(a^.hi, p);
end;


procedure cargararbol(var a: arbol);
var
	p: paquete;
begin
	leer(p);
	while(p.codigo <> 0) do
	begin
		cargar(a, p);
		leer(p);
	end;
end;

procedure mostrardatos(a: arbol);
begin
	if(a <> nil) then
	begin
	mostrardatos(a^.hi);
	write('codigo: ' , a^.dato.codigo);
	write('dni del emisor: ' , a^.dato.dniemisor);
	write('dni del receptor: ' , a^.dato.dnireceptor);
	write('paquetes: ' , a^.dato.paquetes);
	write('peso: ' , a^.dato.peso);
	mostrardatos(a^.hd);
	end;
end;

procedure insertarlista(var l: lista; p: paquete);
var
	nuevoNodo: lista;
begin
	new(nuevoNodo);
	nuevoNodo^.dato := p;
	nuevoNodo^.sig := l;
	l := nuevoNodo;
end;

procedure buscar(a: arbol; min, max: integer; var l: lista);
begin
	if(a <> nil) then
	begin
		buscar(a^.hi, min, max, l);
		if(a^.dato.peso >=min) and (a^.dato.peso <= max) then
		insertarlista(l, a^.dato);
		buscar(a^.hd, min, max, l);
	end;
end;

procedure imprimirlista(l: lista);
begin
	while(l <> nil) do
	begin
		write('codigo: ' , l^.dato.codigo);
		write('dni del emisor: ' , l^.dato.dniemisor);
		write('dni del receptor: ' , l^.dato.dnireceptor);
		write('paquetes: ' , l^.dato.paquetes);
		write('peso: ' , l^.dato.peso);
		l:=l^.sig;
	end;
end;

procedure sacarmayor(a: arbol; var p: paquete);

begin
	if(a <> nil) then
	begin
		sacarmayor(a^.hi, p);
		if(a^.dato.paquetes > p.paquetes) then
		p:=a^.dato;
		sacarmayor(a^.hd, p);
	end;
end;

procedure imprimirmayor(p: paquete);
begin
	writeln('--- Informacion del paquete con mas objetos ---');
	writeln('Codigo de envio: ', p.codigo);
	writeln('DNI emisor: ', p.dniemisor);
	writeln('DNI receptor: ', p.dnireceptor);
	writeln('Cantidad de objetos: ', p.Paquetes);
	writeln('Peso en gramos: ', p.peso);
end;

var
	a: arbol;
	l: lista;
	pmax, pmin: integer;
	maximo: paquete;
begin
	a:=nil;
	l:=nil;
	cargararbol(a);
	mostrardatos(a);
	
	write('ingrese el peso maximo');
	readln(pmax);
	write('ingrese el peso minimo');
	readln(pmin);
	buscar(a, pmin, pmax, l);
	imprimirlista(l);
	
	maximo.paquetes:=-1;
	sacarmayor(a, maximo);
	imprimirmayor(maximo);
end.
