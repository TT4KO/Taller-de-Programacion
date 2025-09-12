type 
subGenero = 1..7;
 libro = record
	 isbn : integer;
	 codAutor : integer;
	 genero : subGenero;
 end;

auto = record
	codigo: integer;
	cantidad: integer;
end;

arbol = ^nodo;
	nodo = record
	dato: auto;
	hd: arbol;
	hi: arbol;
end;

infogenero = record
	codigogenero: integer;
	cantidadlibro: integer;
end;

vector =  array [subgenero] of infogenero ;

procedure iniciarvector(var v: vector);
var
	i: subgenero;
begin
	for i:=1 to 7 do
	v[i].codigogenero:=i;
	v[i].cantidadlibro:=0;
end;
	
procedure leerLibro(var l: libro);
begin
  writeln('Ingrese ISBN (0 para cortar): ');
  readln(l.isbn);
  if (l.isbn <> 0) then
  begin
    writeln('Ingrese codigo de autor: ');
    readln(l.codAutor);
    writeln('Ingrese genero (1..7): ');
    readln(l.genero);
  end;
end;	
	
procedure insertararbol(var a:arbol; codautor: integer);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=codautor;
		a^.dato.cantidad:=1;
		a^.hd:=nil;
		a^.hi:=nil;
	end
	else
	if (codautor = a^.dato.codigo) then
	a^.dato.cantidad:=a^.dato.cantidad + 1
	else
	if(codautor < a^.dato.codigo) then
	insertararbol(a^.hi, codautor)
	else
	insertararbol(a^.hd, codautor);
end;
	
procedure cargar(var a:arbol; var v: vector);
var
	l: libro;
begin
	leerlibro(l);
	while(l.isbn <> 0) do
	begin
		insertararbol(a, l.codautor);
		v[l.genero].cantidadlibro:=v[l.genero].cantidadlibro + 1;
		leerlibro(l);
	end;
end;
		
procedure imprimirarbol(a: arbol);
begin
	if(a <> nil) then
	begin
		writeln('el codigo es: ' );
		write(a^.dato.codigo);
		writeln('la cantidad es: ' );
		write(a^.dato.cantidad);
		imprimirarbol(a^.hi);
		imprimirarbol(a^.hd);
	end;
end;

procedure imprimirvector(v: vector);
var
	i: subgenero;
	nombres: array [1..7] of string = 
    ('literario', 'filosofia', 'biologia', 'arte', 'computacion', 'medicina', 'ingenieria');
begin
	for i:=1 to 7 do
	writeln('genero ' , nombres[i] , ' : ' , v[i].cantidadlibro, ' libros');
end;

var
a: arbol;
v: vector;
begin
	iniciarvector(v);
	a:=nil;
	cargar(a, v);
	imprimirarbol(a);
	imprimirvector(v);
end.
