program iasd;
const
max = 10;
type 

vector = array [1..max] of integer;

procedure cargarvector(var v: vector; var n: integer);
var
	max, min: integer;
	i: integer;
	valor: integer;
begin
	randomize;
	max:=10;
	min:=-5;
	n:= 0;
	for i:=1 to max do
	begin
		valor:=random(max - min + 1) + min;
		v[i]:=valor;
		n:=n + 1;
		if (valor = 0) then
		break;
	end
end;
	
	
procedure imprimirvector(v: vector; n: integer);
var
	i: integer;
begin
	for i:=1 to n do
	write(v[i]);
end;
	
var
	v: vector;
	n: integer;
	
begin
	cargarvector(v, n);
	imprimirvector(v, n);
end.
