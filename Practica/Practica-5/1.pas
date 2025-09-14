program ijdas;
const
dimf = 300;
type
oficinas = record
	codigo: integer;
	dni: integer;
	valor: real;
end;

vector = array [1..dimf] of oficinas;

procedure leer(var o: oficinas);
begin
  write('Codigo: '); readln(o.codigo);
  if o.codigo <> 0 then
  begin
    write('DNI: '); readln(o.dni);
    write('Expensa: '); readln(o.valor);
  end;
end;

procedure cargarvector(var v: vector; var diml: integer);
var
	o: oficinas;
begin
	leer(o);
	while(o.codigo <> 0) and (diml < dimf) do
	begin
		diml:=diml + 1;
		v[diml]:=o;
		leer(o);
	end;
end;

procedure Insercion(var v: vector; dimL: integer);
var
  i, j: integer;
  actual: oficinas;
begin
  for i := 2 to dimL do
  begin
    actual := v[i];
    j := i - 1;
    while (j > 0) and (v[j].codigo > actual.codigo) do
    begin
      v[j+1] := v[j];
      j := j - 1;
    end;
    v[j+1] := actual;
  end;
end;

function fijarse(v: vector; diml, cod: integer): integer;
var
	pri, ult, medio: integer;
begin
	pri:=1;
	ult:=diml;
	fijarse:=0;
	while(pri <=ult) and (fijarse = 0) do
	begin
		medio:=(pri + ult) div 2;
		if (v[medio].codigo = cod) then
		fijarse:=medio
		else
		if(v[medio].codigo > cod) then
		ult:=medio - 1 
		else
		pri:=medio + 1;
	end;
end;

function calcular(v: vector; diml: integer): real;
begin
	if diml = 0 then
		calcular:=0
	else
		calcular:=v[diml].valor + calcular(v, diml - 1);
end;

var
v: vector;
diml: integer;
cod, pos: integer;
total: real;
begin
	diml:=0;
	cargarvector(v, diml);
	insercion(v, diml);
	read(cod);
	pos:=fijarse(v, diml, cod);
	write(v[pos].dni);
	total:=calcular(v, diml);
	write(total);
end.
