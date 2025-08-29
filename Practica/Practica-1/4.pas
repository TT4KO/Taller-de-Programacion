program mkdlas;
const
cant = 6;
maxprod = 30;
type
rangoprod = 1..maxprod;
rangorubro = 1..cant;
producto = record
	codigo: integer;
	rubro: rangorubro;
	precio: real;
end;

lista = ^nodo;
	nodo = record
	dato: producto;
	sig: lista;
end;

vectorrubros = array [rangorubro] of lista;
vectorprod = array [rangoprod] of producto;

procedure iniciar(var v:vectorrubros);
var
	i: rangorubro;
begin
	for i:=1 to cant do
	v[i]:=nil;
end;

procedure leer(var p: producto);
begin
	read(p.codigo);
	if(p.codigo <> -1) then
	read(p.rubro);
	read(p.precio);
end;

procedure insertarOrdenado(var L: lista; p: producto);
var
  nue, act, ant: lista;
begin
  new(nue);
  nue^.dato := p;
  act := L; ant := nil;
  while (act <> nil) and (act^.dato.codigo < p.codigo) do begin
    ant := act;
    act := act^.sig;
  end;
  if (ant = nil) then begin
    nue^.sig := L;
    L := nue;
  end
  else begin
    ant^.sig := nue;
    nue^.sig := act;
  end;
end;

procedure cargarvector(var v: vectorrubros);
var
	p: producto;
begin
	leer(p);
	while(p.precio <> -1) do
	begin
		insertarOrdenado(v[p.rubro], p);
		leer(p);
	end;
end;

procedure mostrarvector(v: vectorrubros);
var
	i: integer;
	l: lista;
begin
	for i:=1 to cant do 
	begin
		write('rubro: ' , i);
		l:=v[i];
		write('codigo: ' , l^.dato.codigo);
	l:=l^.sig;
	end;
end;

procedure productosrubro3(L: lista; var v3: vectorprod; var diml: integer);
begin
	diml:=0;
	while(l <> nil) and (diml < maxprod) do
	begin
		diml:=diml + 1;
		v3[diml]:=l^.dato;
		l:=l^.sig;
	end;
end;

var
v: vectorrubros;
v3: vectorprod;
diml: integer;
begin
	iniciar(v);
	cargarvector(v);
	mostrarvector(v);
	productosrubro3(l, v3, diml);
end.
