{una empresa de gastronomia procesar las entregas de comida realizadas a sus clientes durante el año 2022.
a) Implementar un módulo que lea entregas de comidas. De cada compra se lee código de comida, código de cliente
canpras y categoria de la entrega (Full',"Super',Media', 'Normal, Basica). La lectura finaliza con el código de cliente 0. 
Se sugiere utilizar el módulo leerEntrega(). Se deben retornar 2 estructuras de datos:

I. Un árbol binario de búsqueda ordenado por código de comida. Para cada código de comida debe almacenarse la
cantidad de entregas realizadas a ese código entre todos los clientes.

il. Un vector que almacene en cada posición el nombre de la categoria y la cantidad de entregas realadas para esa
categoria.

b) Implementar un módulo que reciba el árbol generado en a) y un código de comida. El módalo debe retornar la
cantidad de entregas realizadas al código de comida ingresado.
c) Implementar un módulo que reciba el vector generado en a), lo ordene por cantidad de entregas de menor a
mayor y retorne la categoria con mayor cantidad de entregas.}

program  laksd;
type
rango = 1..5;
compra = record
	codigocomida: integer;
	cliente: integer;
	categoria: rango;
end;

infocomida = record
	codigo: integer;
	cantidad: integer;
end;

arbol = ^nodo;
	nodo = record
	dato: infocomida;
	hd, hi: arbol;
end;

infovector = record
	nombre: string;
	cantidadcat: integer;
end;

vector = array [rango] of infovector;

procedure iniciarvector(var v: vector);
var
	i: rango;
begin
	for i:=1 to 5 do
	begin
		case i of
			1 : v[i].nombre:='full';
			2 : v[i].nombre:='super';
			3 : v[i].nombre:='media';
			4 : v[i].nombre:='normal';
			5 : v[i].nombre:='basica';
		end;
		v[i].cantidadcat:=0;
	end;
end;

procedure leer(var c: compra);
begin
	read(c.cliente);
	if(c.cliente <> 0) then
	begin
		read(c.codigocomida);
		read(c.categoria);
	end;
end;

procedure agregar(var a: arbol; c: compra);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=c.codigocomida;
		a^.dato.cantidad:=1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(a^.dato.codigo = c.codigocomida) then
	a^.dato.cantidad:=a^.dato.cantidad + 1
	else
	if(c.codigocomida < a^.dato.codigo) then
	agregar(a^.hi, c)
	else
	agregar(a^.hd, c);
end;


procedure cargar(var a: arbol; var v: vector);
var
	c: compra;
begin
	leer(c);
	while(c.cliente <> 0) do
	begin
		agregar(a, c);
		v[c.categoria].cantidadcat:=v[c.categoria].cantidadcat + 1;
		leer(c);
	end;
end;

function total(a: arbol; cod: integer): integer;
begin
	if(a = nil) then
	total:=0
	else
	if (a^.dato.codigo = cod) then
		total:=a^.dato.cantidad
	else
	if(cod < a^.dato.codigo) then
		total:= total(a^.hi, cod)
	else
		total:=total(a^.hd, cod);
end;

Procedure insercion ( var v: vector);
Var
 i, j: integer; 
 actual: infovector;	
begin
 for i:= 2 to 5 do begin 
     actual:= v[i];
     j:= i-1; 
     while (j > 0) and (v[j].cantidadcat > actual.cantidadcat) do      
       begin
         v[j+1]:= v[j];
         j:= j - 1;                  
       end;  
     v[j+1]:= actual; 
 end;
end;		

function maximacantidad(V: vector):string;
begin
	maximacantidad:=v[5].nombre;
end;

var
	a: arbol;
	v: vector;
	cod: integer;
begin
	a:=nil;
	iniciarvector(v);
	cargar(a, v);
	
	read(cod);{b}
	write(total(a, cod));{b}
	
	insercion(v);{c}
	maximacantidad(v);{c}
end.
