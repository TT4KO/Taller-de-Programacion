{para el procesamiento de las atenciones realizadas a los pacientes durante el año 2023. 
a) Implementar un módulo que lea información de las atenciones y retorne un vector donde se almacenen las atenciones agrupadas por mes.
   Las atenciones de cada mes deben quedar almacenadas en un árbol binario de búsqueda ordenado por DNI del paciente y sólo deben almacenarse dni 
   del paciente y código de diagnóstico. De cada atención se lee: matrícula del médico, DNI del paciente, mes y diagnóstico (valor entre Ly P). 
   La lectura finaliza con matrícula 0.
b)implementar un modulo recursivo que reciba el vector generado en a) y retorne el mes con mayor cantidad de atenciones
c)implementar un modulo que recib a el vector generado en a) y un DNI de paciente, y retorne si fue atendido o no, el paciente con el DNI ingresado}

program iajsd;
type
rangomes = 1..12;
rango = 'L'..'P';
atencion = record
	matricula: integer;
	dni: integer;
	mes: rangomes;
	diagnostico: rango;
end;

paciente = record
	dni2: integer;
	codigo: rango;
end;

arbol = ^nodo2;
	nodo2 = record
	dato: paciente;
	hi, hd: arbol;
end;


vector = array [rangomes] of arbol;


procedure iniciar(var v: vector);
var
	i: integer;
begin
	for i:=1 to 12 do
	v[i]:= nil;
end;

procedure leer(var a: atencion);
var
	v: array[1..5] of rango = ('L', 'M', 'N', 'O', 'P');
begin
	a.matricula:=Random(10000);
	if(a.matricula <> 0) then
	begin
		a.dni:=Random(5000)+1000;
		a.mes:=Random(12)+1;
		a.diagnostico:=v[Random(5)+1];
	end;
end;

procedure agregar(var a: arbol; at: atencion);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.dni2:=at.dni;
		a^.dato.codigo:=at.diagnostico;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(at.dni < a^.dato.dni2) then
		agregar(a^.hi, at)
	else
		agregar(a^.hd, at);
end;

procedure cargar(var v: vector);
var
	a: atencion;
begin
	leer(a);
	while(a.matricula <> 0) do
	begin
		agregar(v[a.mes], a);
		leer(a);
	end;
end;	
	
function contarNodos(a: arbol): integer;
begin
  if (a = nil) then
    contarNodos := 0
  else
    contarNodos := 1 + contarNodos(a^.hi) + contarNodos(a^.hd);
end;

procedure encontrarMesMax(v: vector; mesActual: integer; var maxMes: integer; var maxCant: integer);
var
  cant: integer;
begin
  if (mesActual <= 12) then
  begin
    cant := contarNodos(v[mesActual]);
    if (cant > maxCant) then
    begin
      maxCant := cant;
      maxMes := mesActual;
    end;
    encontrarMesMax(v, mesActual + 1, maxMes, maxCant);
  end;
end;


function mesConMasAtenciones(v: vector): integer;
var
  maxMes, maxCant: integer;
begin
  maxMes := 0;
  maxCant := -1;
  encontrarMesMax(v, 1, maxMes, maxCant);
  mesConMasAtenciones := maxMes;
end;

function fijarse(a: arbol; dni: integer):boolean;
begin
	if(a = nil) then
	fijarse:=false
	else
	if(a^.dato.dni2 = dni) then
		fijarse:=true
	else
	if(a^.dato.dni2 < dni) then
		fijarse:=fijarse(a^.hi, dni)
	else
		fijarse:=fijarse(a^.hd, dni);
end;


function puntoc(v: vector; deni: integer):boolean;
var
	i: integer;
begin
	i:=1;
	puntoc:=false;
	while(i <= 12) and (puntoc = false) do
	begin
		if (fijarse(v[i], deni)) then
		puntoc:=true;
		i:=i + 1;
	end;
end;
		
var
	v: vector;
	deni: integer;
begin
	Randomize;
	iniciar(v);
	cargar(v);
	mesConMasAtenciones(v);
	read(deni);
	if(puntoc(v, deni)) then
		write('si se atendion')
		else
		write('no se atendio');
end.
