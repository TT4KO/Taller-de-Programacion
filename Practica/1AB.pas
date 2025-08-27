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
		
procedure insercion(var v: vector; diml: integer);
var
	i, j: integer;
	o: oficinas;
begin
	for i:=2 to diml do 
	begin
		o:= v[i];
		j:= i -1;
		while (j > 0) and (v[j].codigo > o.codigo) do 
		begin
			v[j+1]:=v[j];
			j:=j - 1;
		end;
	v[j+1]:=o;
	end;
end;
	
	
var
v: vector;
diml: integer;
i: integer;
begin
	cargarvector(v, diml);
	insercion(v, diml);
	writeln('datos del vector: ' );
	for i:=1 to diml do
	writeln('Codigo: ', v[i].codigo, ' - DNI: ', v[i].dni, ' - Valor: ', v[i].valor:0:2);
end.
