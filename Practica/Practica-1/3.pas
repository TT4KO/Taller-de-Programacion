program dasl;
const
  cant = 8;  { géneros 1..8 }

type
  rangogenero = 1..cant;

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
  
  peliculaMax = record
    codigo: integer;
    puntaje: real;
  end;

 vectorMax = array [rangogenero] of peliculaMax;
 vectorLista = array [rangogenero] of lista;


procedure iniciar(var v: vectorlista; var ult: lista);
var
	i: integer;
begin
	for i:=1 to cant do 
	begin
		v[i]:=nil;
		ult:=nil;
	end;
end;

procedure leer(var p: pelicula);
begin
  write('codigo: ');  readln(p.codigo);
  if (p.codigo <> -1) then begin
    write('genero: ');  readln(p.genero);
    write('puntaje: '); readln(p.puntaje);
  end;
end; 

procedure atras(var L, Ult: lista; p: pelicula);
var
  nue: lista;
begin
  new(nue); nue^.dato := p; nue^.sig := nil;
  if (L = nil) then L := nue
  else Ult^.sig := nue;
  Ult := nue;
end;

procedure cargar(var v: vectorlista; var ult: lista);
var
	p: pelicula;
begin
	leer(p);
	while(p.codigo <> -1) do
	begin
		atras(v[p.genero], ult, p);
		leer(p);
	end;
end;
 
procedure maximo(v: vectorlista; var vmax:vectormax);
var
	i: integer;
	maxpuntaje: real;
	maxcodigo: integer;
	aux: lista;
begin 
	for i:=1 to cant do
	begin
		aux:=v[i];
		maxpuntaje:=-1;
		maxcodigo:=-1;
		while(aux <> nil) do
		begin
			if(aux^.dato.puntaje > maxpuntaje) then
			begin
				maxpuntaje:=aux^.dato.puntaje;
				maxcodigo:=aux^.dato.codigo;
			end;
			aux:=aux^.sig;
		end;
		vmax[i].codigo:=maxcodigo;
		vmax[i].puntaje:=maxcodigo;
	end;
end;

procedure ordenado(var v: vectorMax; diml: integer);
var
  i, j: integer;
  aux: peliculaMax;
begin
  for i := 1 to cant-1 do
    for j := 1 to cant-i do
      if (v[j].puntaje > v[j+1].puntaje) then
      begin
        aux := v[j];
        v[j] := v[j+1];
        v[j+1] := aux;
      end;
end;

procedure codigomaximo(v: vectormax; diml: integer);
var
	codigomax, codigomin: integer;
	i: integer;
	maxpuntaje, minpuntaje: real;
begin
	maxpuntaje:=-1; 
	minpuntaje:=9999;
	codigomax:=-1;
	codigomin:=-1;
	for i:= 1 to diml do
	begin
		if(v[i].puntaje > maxpuntaje) then
		begin
			maxpuntaje:=v[i].puntaje;
			codigomax:=v[i].codigo;
		end;
		if(v[i].puntaje < minpuntaje) then
		begin
			minpuntaje:=v[i].puntaje;
			codigomin:=v[i].codigo;
		end;
		write(codigomin);
		write(codigomax);
	end;
end;
		
var
vmax: vectorMax;
v: vectorlista;
ult: lista;
begin
	iniciar(v, ult);{a}
	cargar(v, ult);{a}
	maximo(v, vmax);{b}
	ordenado(vmax, cant);{c}
	codigomaximo(vmax, cant)
end.
