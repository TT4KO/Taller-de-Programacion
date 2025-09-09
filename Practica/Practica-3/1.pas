program iasd;

type
socio =  record
	numero: integer;
	nombre: string;
	edad: integer;
end;

arbol = ^nodo;
	nodo = record
	dato: socio;
	hd: arbol;
	hi: arbol;
end;

procedure leer(var s: socio);
var 
	vNombres:array [0..9] of string= ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola'); 
begin
	s.numero:=random(500);
	if(s.numero <> 0) then
	begin
		s.nombre:=vnombres[random(10)];
		s.edad:=19 + random(63);
	end;
end;

procedure agregar(var a: arbol; s: socio);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato:=s;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(s.numero < a^.dato.numero) then
		agregar(a^.hi, s)
	else
		agregar(a^.hd, s);
end;


procedure cargararbol(var a: arbol);
var
	s: socio;
begin
	leer(s);
	while(s.numero <> 0) do
	begin
		agregar(a, s);
		leer(s);
	end;
end;

procedure informarenorden(a: arbol);
begin
	if(a <> nil) then
	begin
		informarenorden(a^.hi);
			writeln('numero: '  , a^.dato.numero);
			writeln('nombre: ' , a^.dato.nombre);
			writeln('edad: ' , a^.dato.edad);
		informarenorden(a^.hd);
	end;
end;

procedure informardecreciente(a: arbol);
begin
	if(a <> nil) then
	begin
		informardecreciente(a^.hd);
			writeln('numero: ' , a^.dato.numero);		
			writeln('nombre: ' , a^.dato.nombre);
			writeln('edad: ' , a^.dato.edad);
		informardecreciente(a^.hi);
	end;
end;

procedure sociomasviejo(a: arbol; var nummax, edadmax: integer);
begin
	if(a <> nil) then
	begin
		if(a^.dato.edad > edadmax) then
		begin
			edadmax:=a^.dato.edad;
			nummax:=a^.dato.numero;
	end;
	sociomasviejo(a^.hi, nummax, edadmax);
	sociomasviejo(a^.hd, nummax, edadmax);
	end;
end;

function buscar(a: arbol; n: string): boolean;
begin
  if (a = nil) then
    buscar := false
  else if (a^.dato.nombre = n) then
    buscar := true
  else
    buscar := buscar(a^.hi, n) or buscar(a^.hd, n);
end;

function contartotal(a: arbol): integer;
begin
	if(a = nil) then
	contartotal:=0
	else	
	contartotal:=1 + contartotal(a^.hi) +  contartotal(a^.hd);
end;

var
a: arbol;
nummax, edadmax: integer;
nomb: string;
total: integer;
begin
	randomize;
	a:=nil;
	cargararbol(a);
	informarenorden(a);{i}
 
	write('a partir de aca se imprime de otra forma');
	informardecreciente(a);{ii}
 
	sociomasviejo(a, nummax, edadmax);
	writeln('la cantidad de gente mayor es: ' , nummax);{iii}
	
	writeln('coloque un nombre para buscar: ');{v}
	read(nomb);{v}
	if buscar(a, nomb) then{v}
	write('se encontro'){v}
	else
	write('no se encontro');{v}
	total:=contartotal(a);{vi}
	writeln('el total de socios son: ' , total);{vi}
end.
