program mkdlas;
const
cantgenero = 8;
type
rangogenero = 1..cantgenero;
pelicula = record
	codigo: integer;
	genero: rangogenero;
	puntaje: real;
end;

lista = ^nodo;
	nodo = record
	dato: pelicula;
	sig: lista;
end;	

vectorgenero = array [rangogenero] of integer;
vectorpuntaje = array [rangogenero] of real;
	
procedure leer(var p: pelicula);
begin
	write('codigo: ' );
	read(p.codigo);
	if (p.codigo <> -1) then
	write('genero: ' );
	read(p.genero);
	write('puntaje: ' );
	read(p.puntaje);
end;

procedure atras(var L,Ult: lista; p: pelicula);
var
  nue: lista;
begin
  new(nue);
  nue^.dato:= p;
  nue^.sig:= nil;
  if(L = nil) then //si es el primer nodo
    L:= nue
  else      // si no es el primer nodo
    Ult^.sig:= nue;
  Ult:= nue;
end;

procedure cargarlista(var l: lista);
var
	ult: lista;
	p: pelicula;
begin
	leer(p);
	while(p.codigo <> -1) do
	begin
		atras(l, ult, p);
		leer(p);
	end;
end;

procedure mejorpuntaje(l: lista; var mp: vectorgenero);
var
	aux: lista;
	i: integer;
begin
	for i:=1 to cantgenero do
	mp[i]:=-1;
	aux:=l;
	while(aux <> nil) do
	begin
		if (mp[aux^.dato.genero] = -1) or (aux^.dato.puntaje > mp[aux^.dato.genero]) then
		begin
			mp[aux^.dato.genero]:=aux^.dato.codigo;
		end;
	aux:=aux^.sig;
	end;
end;

procedure ordenar(var v: vectorgenero; dimf: integer);
var
	i, j, pos: integer; 
	temp: integer;
begin
	for i:=1 to dimf - 1 do
	begin
		pos:=i;
		for j := i + 1 to dimf do
    begin
      if (v[j] > v[pos]) then
        pos := j; // Encuentra el índice del máximo
    end;
    // Intercambiar los elementos
    if pos <> i then
    begin
      temp := v[pos];
      v[pos] := v[i];
      v[i] := temp;
    end;
  end;
end;

procedure informar(vp: vectorpuntaje; dimf: integer);
var
	i: rangogenero;
	maxc, minc: integer;
	maxp, minp: real;
begin
	maxc:=-1;
	minc:=9999;
	maxp:= -1;
	minp:=9999;
	for i:= 1 to dimf do
	begin
		if(vp[i] > -1) then
		begin
			if(vp[i] > maxp) then
			maxp:= vp[i];
			maxc:=i;
		end;
		if(vp[i] < minp) then
		begin
			minp:=vp[i];
			minc:=i;
		end;
	end;
	write('el codigo con mayor puntaje: ' , maxc);
	write('el codigo con menor puntaje: ' , minc);
end;
	
procedure iniciarvector(var vp: vectorpuntaje);
var
	i: rangogenero;
begin
	for i:=1 to cantgenero do
	vp[i]:=0;
end;

var
l: lista;
v: vectorgenero;
dimf, i: integer;
vp: vectorpuntaje;
begin
	dimf:= 0;
	l:=nil;
	cargarlista(l);
	mejorpuntaje(l, v);
	
	for i:=1 to cantgenero do
	begin
		if (v[i] <> -1) then
		dimf:=dimf + 1;
	end;
	ordenar(v, dimf);
	iniciarvector(vp);
	informar(vp, dimf);
end.
