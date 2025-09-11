program idas;
type
rango = 2015..2024;
auto = record
	patente: integer;
	anio: rango;
	marca: string;
	color: string;
	modelo: string;
end;

arbol = ^nodo;
	nodo = record
	dato: auto;
	hd: arbol;
	hi: arbol;
end;

infomarca = record
	patente: integer;
	color: string;
end;

lista = ^nodo3;
	nodo3 = record
	dato: infomarca;
	sig: lista;
end;

marcaauto = record
	marca: string;
	info: lista;
end;

arbol2 = ^nodo2;
	nodo2 = record
	dato: marcaauto;
	hd: arbol2;
	hi: arbol2;
end;

procedure leer(var a: auto);
begin
	read(a.modelo);
	if(a.modelo <> 'MMM') then
	begin
		read(a.patente);
		read(a.anio);
		read(a.color);
		read(a.marca);
	end;
end;

procedure cargar(var a: arbol; au: auto);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato:=au;
		a^.hd:=nil;
		a^.hi:=nil
	end
	else
	if(a^.dato.patente < au.patente) then
	cargar(a^.hi, au)
	else
	cargar(a^.hd, au);
end;

procedure agregarlista(var l: lista; inf: infomarca);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l;
  l := nue;
end;

procedure otroarbol(var a: arbol2; au: auto);
var
	inf: infomarca;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.marca:=au.marca;
		a^.dato.info:=nil;
		
		inf.patente:=au.patente;
		inf.color:=au.color;
		
		agregarlista(a^.dato.info, inf);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(au.marca < a^.dato.marca) then
	otroarbol(a^.hi, au) 
	else
	if(au.marca > a^.dato.marca) then
	otroarbol(a^.hd, au)
	else
	begin
		inf.patente:=au.patente;
		inf.color:=au.color;
		agregarlista(a^.dato.info, inf);
	end;
end;

procedure cargar(var a:arbol; var a2: arbol2);
var
	au: auto;
begin
	leer(au);
	while(au.marca <> 'MMM') do
	begin
		cargar(a, au);
		otroarbol(a2, au);
		leer(au);
	end;
end;

function mismamarca(a: arbol; marca: string): integer;
begin
	if(a = nil) then
	mismamarca:=0;
	begin
		if(a^.dato.marca = marca) then
		mismamarca:=1 + mismamarca(a^.hi, marca) + mismamarca(a^.hd, marca);
		mismamarca:=mismamarca(a^.hi, marca) + mismamarca(a^.hd, marca);
	end;
end;

function contarLista(l: lista): integer;
begin
  if (l = nil) then
    contarLista := 0
  else
    contarLista := 1 + contarLista(l^.sig);
end;

function mismamarca2(a: arbol2; m: string): integer;
begin
	if(a <> nil) then
	mismamarca2:=0
	else
		if(a^.dato.marca = m) then
		mismamarca2:=contarlista(a^.dato.info)
	else
	if(m < a^.dato.marca) then
	mismamarca2(a^.hd, m)
	else
	mismamarca2(a^.hi, m);
end;

var
	a: arbol;
	a2: arbol2;
	totalmarca: integer;
	marcaleida: string;
	totalmarca2: integer;
	marcaleida2: string;
begin
	a:=nil;
	a2:=nil;
	cargar(a, a2);{a}
	read(marcaleida);{b}
	totalmarca:=mismamarca(a, marcaleida);{b}
	write('total de autos con la misma marca: ' , totalmarca);{b}
	read(marcaleida2);{c}
	totalmarca2:=mismamarca2(a2, marcaleida2);{c}
	write(totalmarca2);{c}
end.
	
