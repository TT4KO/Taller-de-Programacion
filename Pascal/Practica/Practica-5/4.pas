program iasd;
type
rango = 1..7;
libro = record
	isbn: integer;
	codigoautor: integer;
	genero: rango;
end;

infogenero = record
	codigogenero: integer;
	cantidadlibro: integer;
end;

vector = array [rango] of infogenero;

autor = record
	codigo: integer;
	cantidad: integer;
end;

arbol =  ^nodo;
	nodo = record
	dato: autor;
	hd, hi: arbol;
end;

procedure iniciar(var v: vector);
var
	i: rango;
begin
	for i:=1 to 7 do
	begin
		v[i].codigogenero:=i;
		v[i].cantidadlibro:=0;
	end;
end;

procedure leer (var l : libro);
begin
 l.isbn := Random(1000);
 if (l.isbn <> 0) then begin
 l.codigoAutor := Random(300) + 100;
 l.genero := Random(7) + 1;
 end;
end;

procedure agregar(var a: arbol; l: libro);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=l.codigoautor;
		a^.dato.cantidad:= 1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(a^.dato.codigo = l.codigoautor) then
	a^.dato.cantidad:=a^.dato.cantidad + 1
	else
	if (l.codigoautor <a^.dato.codigo) then
	agregar(a^.hi, l)
	else
	agregar(a^.hd, l);
end;

procedure cargar(var a: arbol; var v: vector);
var
	l: libro;
begin
	leer(l);
	while(l.isbn <> 0) do
	begin
		agregar(a, l);
		v[l.genero].cantidadlibro:=v[l.genero].cantidadlibro + 1;
		leer(l);
	end;
end;

Procedure insercion ( var v: vector);
Var
 i, j: integer; 
 actual: infogenero;		
begin
 for i:= 2 to 7 do 
	begin 
     actual:= v[i];
     j:= i-1; 
     while (j > 0) and (v[j].cantidadlibro > actual.cantidadlibro) do      
       begin
         v[j+1]:= v[j];
         j:= j - 1;                  
       end;  
     v[j+1]:= actual; 
 end;
end;

function nombregenero(cod: integer):string;
begin
	case cod of
	1: nombregenero:= 'literario';
	2: nombreGenero := 'Filosofia';
    3: nombreGenero := 'Biologia';
    4: nombreGenero := 'Arte';
    5: nombreGenero := 'Computacion';
    6: nombreGenero := 'Medicina';
    7: nombreGenero := 'Ingenieria';
  else
    nombreGenero := 'Desconocido';
  end;
end;

function generomayor(v: vector): string;
begin
	insercion(v);
	generomayor:=nombregenero(v[1].codigogenero);
end;

function cantidadlibros(a: arbol; codmin: integer; codmax: integer): integer;
begin
	if(a = nil) then
	cantidadlibros:=0
	else
	begin
		if(a^.dato.codigo >= codmin) and (a^.dato.codigo <= codmax) then
		cantidadlibros:=a^.dato.cantidad +cantidadlibros(a^.hi, codmin, codmin) + cantidadlibros(a^.hd, codmin, codmin)
		else
		if(a^.dato.codigo < codmin) then
		cantidadlibros:=cantidadlibros(a^.hi, codmin, codmin)
		else
		cantidadlibros:=cantidadlibros(a^.hd, codmin, codmin);
end;
end;  
		

var
	a: arbol;
	v: vector;
	gmayor: string;
	codmin, codmax: integer;
	total: integer;
begin
	iniciar(v);
	randomize;
	a:=nil;
	cargar(a, v);{a}

	gmayor:=generomayor(v);{b}
	write(gmayor);{b}
	
	read(codmin);{c}
	read(codmax);{c}
	total:=cantidadlibros(a, codmin, codmax);{c}
	write(total);{c}
end.


