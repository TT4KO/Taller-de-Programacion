program iasd;
const
dimf =  4;
type
rangodim =  1..dimf;
oficinas = record
		codigo: integer;
		dni: integer;
		valor: real;
end;	

vector = array [rangodim] of oficinas;

procedure leer(var o:oficinas);
begin
	write('codigo: ' );
	read(o.codigo);
	if(o.codigo <> -1) then
	begin
		write('dni: ' );
		read(o.dni);
		write('valor: ' );
		read(o.valor);
	end;
end;

procedure cargarvector(var v: vector; var diml: integer);
var
	o: oficinas;
begin
	diml:=0;
	leer(o);
	while(o.codigo <> -1) and (diml < dimf) do
	begin
		diml:=diml + 1;
		v[diml]:=o;	
		if(diml < dimf) then
		leer(o);
	end;
end;
		
Procedure seleccion ( var v: vector; dimL: integer);
var 
	i, j, pos: integer; 
	o : oficinas;		
begin
for i:=1 to (dimL-1) do 
	begin 
		pos := i;
		for j := i+1 to dimL do
		if v[j].codigo < v[pos].codigo then 
		pos:=j;
		o := v[pos];   
		v[pos] := v[i];   
		v[i] := o;
    end;
end;
	
var
v: vector;
diml: integer;
i: integer;
begin
	cargarvector(v, diml);
	seleccion(v, diml);
	writeln('datos del vector: ' );
	for i:=1 to diml do
	writeln('Codigo: ', v[i].codigo, ' - DNI: ', v[i].dni, ' - Valor: ', v[i].valor:0:2);
end.
