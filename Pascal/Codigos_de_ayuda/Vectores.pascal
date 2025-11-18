{ii. Un vector que almacene para cada material base, el código del material base y la cantidad de artesanías del material base.}
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
vector = array[rangoCodigo] of regVector;

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

procedure cargarDatos(var a: arbol; var v: vector);
var
	art: artesania;
begin
	leerArtesania(art);
	while(art.dni <> 0)do
	begin
		v[art.codigo].cant := v[art.codigo].cant + 1;
	end;
end;
-----------------------------------------------------------------------------------
{ii.Un vector que almacene en cada posicion el tipo de genero y la lista de los dni de pacientes atendidos con ese diagnosticio.}

program iajsd;
type
rango = 'A'..'F';
atencion = record
	matricula: integer;
	dni: integer;
	dia: integer;
	diagnostico: rango;
end;
lista = ^nodo2;
	nodo2 = record
	dato: integer;
	sig: lista;
end;
vector = array [rango] of lista;

procedure iniciar(var v: vector);
var
	i: rango;
begin
	for i:='A' to 'F' do
	v[i]:=nil;
end;
procedure adelante(var l: lista; dni: integer);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dato := dni;
  nuevo^.sig := l;
  l := nuevo;
end;
procedure cargar(var v: vector);
var
	at: atencion;
begin
	leer(at);
	while(at.dni <> 0) do
	begin
		adelante(v[at.diagnostico], at.dni);
		leer(at);
	end;
end;
