{de cada atencion se lee: matricula del medico, dni del paciente, dia y diagnostico(valor entre A y F). La lectura finaliza con le dni 0. Se sugier eutilzair el modulo leeratacion(). El modulo debe retornar dos estructuras
i. Un arbol binario con busqueda ordenado por matricula del medico. Para cada matricula de mecido debe almacenarse la cantidad de atenaciones realizada.
ii.Un vector que almacene en cada posicion el tipo de genero y la lista de los dni de pacientes atendidos con ese diagnosticio.

b)implementar un modulo que reciba el arbol generado en a), una matricula y retorne la cantidad total de atenciones realizadas por los medicos con matricula superior a la matricula ingresada

c) realizar un modulo recursivo que reciba el vector generado en a) y retorne el diagnostico con mayor cantida de pacientes atentidos.}

program asd;
const
	diagmin = 1;
	diagmax = 6;
type
rangodiag = diagmin..diagmax;
atencion = record
	matricula: integer;
	dni: integer;
	dia: integer;
	diagnostico: char;
end;

medico = record
	matricula: integer;
	cantidad: integer;
end;

arbol = ^nodo;
	nodo = record
	dato: medico;
	hd, hi: arbol;
end;

lista = ^nodo2;
	nodo2 = record
	dni: integer;
	sig: lista;
end;

vector = array [rangodiag] of lista;

procedure iniciar(var v: vector);
var
	i: rangodiag;
begin
	for i:=diagmin to diagmax do
	v[i]:=nil;
end; 

procedure leeratencion(var a: atencion);
var
	v: array [1..6] of char = ('A', 'B', 'C', 'D', 'E', 'F');
begin
	a.dni:=random(5000);
	if(a.dni <> 0) then
	begin
		a.matricula:=random(1000)+2000;
		a.dia:=random(31)+1;
		a.diagnostico:=v[random(6)+1];
	end;
end;

procedure agregar(var a: arbol; at: atencion);
begin
	if (a = nil) then
	begin
		new(a);
		a^.dato.matricula:=at.matricula;
		a^.dato.cantidad:= 1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(at.matricula = a^.dato.matricula) then
	a^.dato.cantidad:=a^.dato.cantidad + 1
	else
	if(at.matricula < a^.dato.matricula) then
		agregar(a^.hi, at)
		else
	agregar(a^.hd, at);
end;

function indice(d: char): integer;
begin
  case d of
    'A': indice := 1;
    'B': indice := 2;
    'C': indice := 3;
    'D': indice := 4;
    'E': indice := 5;
    'F': indice := 6;
  else
    indice := 0; 
  end;
end;

procedure agregarAdelante(var l: lista; dni: integer);
var
  nuevo: lista;
begin
  new(nuevo);
  nuevo^.dni := dni;
  nuevo^.sig := l;
  l := nuevo;
end;

procedure agregarvector(var v: vector; at: atencion);
var
	i: integer;
begin
	i:=indice(at.diagnostico);
	if (i <> 0) then
	agregaradelante(v[i], at.dni);
end;

procedure cargar(var a: arbol; var v: vector);
var
	at: atencion;
begin
	leeratencion(at);
	while(at.dni <> 0) do
	begin
		agregar(a, at);
		agregarvector(v, at);
		leeratencion(at);
	end;
end; 

function atenciones(a: arbol; num: integer): integer;
begin
	if(a = nil) then
	atenciones:=0
	else
	begin
	if(a^.dato.matricula > num) then
	atenciones:=a^.dato.cantidad + atenciones(a^.hi, num) + atenciones(a^.hd, num)
	else
	atenciones:=atenciones(a^.hd, num);
end;  
end;

procedure mayor(v: vector; max: integer);
begin
	
	

var
	v: vector;
	a: arbol;
	matri: integer;
	total: integer;
begin
	iniciar(v);
	a:=nil;
	cargar(a, v);{a}{b}
	
	read(matri);
	total:=atenciones(a, matri);
	write(total);
end.
