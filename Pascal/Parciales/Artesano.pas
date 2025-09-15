{La Feria del Artesano necesita un sistema para obtener estadísticas sobre las artesanías presentadas.

A) Implementar un módulo que lea la información de las artesanías. 
De cada artesanía se conoce: número de identificación de la artesanía, 
DNI del artesano y código del material base (1: madera, 2: yeso, 3: cerámica, 4: vidrio, 5: acero, 6: porcelana, 7: lana, 8: cartón). 
La lectura finaliza con el valor 0 para el DNI. El módulo debe retornar dos estructuras:

i. Un árbol binario de búsqueda ordenado por el DNI del artesano. 
Para cada DNI del artesano debe almacenarse la cantidad de artesanías correspondientes al DNI. 
ii. Un vector que almacene para cada material base, el código del material base y la cantidad de artesanías del material base.

b) Implementar un módulo que reciba el árbol generado en a) y un DNI. 
El módulo debe retornar la cantidad de artesanos con DNI menor al DNI ingresado. 

c) Implementar un módulo que reciba el vector generado en a), 
lo ordene por cantidad de artesanías de menor a mayor y retorne el nombre de material base con mayor cantidad de artesanías.
}

program feriaArtesano;

type 
rangoCodigo = 1..8;
artesania = record
	nro: integer;
	dni: integer;
	codigo: rangoCodigo;
end;
	
regVector = record
	codigo: integer;
	cant: integer;
end;

regarbol = record
	dni: integer;
	cant: integer;
end;

vector = array[rangoCodigo] of regVector;
	
arbol = ^nodoArbol;
nodoArbol = record
	dato: regarbol;
	HI: arbol;
	HD: arbol;
end;
	
	
procedure inicializarVector(var v: vector);
var
	i: integer;
begin
	for i := 1 to 8 do
	begin
		v[i].codigo := i;
		v[i].cant := 0;
	end;
end;

procedure leerArtesania(var a: artesania);
begin
	a.dni := random(100);
	write('DNI: ', a.dni);
	if(a.dni <> 0)then
	begin
		a.nro := random(100)+2000;
		write(' | nro: ', a.nro);
		a.codigo := random(8)+1;
		write(' | codigo: ', a.codigo);
		writeln;
	end;
end;

procedure agregarAlArbol(var a: arbol; art: artesania);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.dni:=art.dni;
		a^.dato.cant:= 1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(a^.dato.dni = art.dni) then
		a^.dato.cant:=a^.dato.cant + 1
	else
	if(art.dni < a^.dato.dni) then	
		agregarAlArbol(a^.hi, art)
	else
		agregarAlArbol(a^.hd, art);
end;

procedure cargarDatos(var a: arbol; var v: vector);
var
	art: artesania;
begin
	leerArtesania(art);
	while(art.dni <> 0)do
	begin
		agregarAlArbol(a, art);
		v[art.codigo].cant := v[art.codigo].cant + 1;
		leerArtesania(art);
	end;
end;

function contardni(a: arbol; dni: integer): integer;
begin
	if(a = nil) then
	contardni:=0
	else
	if(dni > a^.dato.dni) then
	contardni:=1 + contardni(a^.hi, dni) + contardni(a^.hi, dni)
	else
	contardni:=contardni(a^.hi, dni)
end;

Procedure insercion ( var v: vector);
Var
 i, j: integer; 
 actual: regvector;	
begin
 for i:= 2 to 8 do begin 
     actual:= v[i];
     j:= i-1; 
     while (j > 0) and (v[j].cant > actual.cant) do      
       begin
         v[j+1]:= v[j];
         j:= j - 1;                  
       end;  
     v[j+1]:= actual; 
 end;
end;

function materialmax(V: vector):string;
var
	 nombres: array[1..8] of string = 
	('Madera', 'Yeso', 'Ceramica', 'Vidrio',
    'Acero', 'Porcelana', 'Lana', 'Carton');
begin
	materialmax:=nombres[v[8].codigo];
end;

var
	a: arbol;
	v: vector;
	dni2: integer;
begin
	a:=nil;
	inicializarVector(v);
	cargardatos(a, v);
	
	read(dni2);{b}
	write(contardni(a, dni2));{b}
	
	insercion(v);{c}
	write('el material con mayor cantidad de artesanias es: ' , materialmax(v));{c}
