program idas;
const
dimf = 20;
valormin = 20;
valormax = 300;
type
vector = array [1..dimf] of integer;



procedure cargarvector(var v: vector; i: integer);

begin
	if (i <= dimf) then
	begin
		v[i]:=valormin + random(valormax - valormin + 1);
		cargarvector(v, i+1);
	end;
end;
 
procedure mostrarvector(v: vector; i: integer);
begin
	if(i <= dimf) then
	begin
		writeln(v[i]);
		mostrarvector(v, i+1);
	end;
end;
 
procedure insercion(var v: vector; dimf: integer);
var
	i, j: integer;
	actual: integer;
begin
	for i:=2 to dimf do 
	begin
		actual:= v[i];
		j:= i -1;
		while (j > 0) and (v[j] > actual) do 
		begin
			v[j+1]:=v[j];
			j:=j - 1;
		end;
	v[j+1]:=actual;
	end;
end; 
 
var
v: vector;
begin
	randomize;
	cargarvector(v, 1);{a}
	mostrarvector(v, 1);{a}
	insercion(v, dimf);{b}
	write('vector ordenado');
	mostrarvector(v, 1);{b}
end.
