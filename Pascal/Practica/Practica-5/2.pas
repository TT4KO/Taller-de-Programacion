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

listaanio = ^nodo4;
	nodo4 =  record
	dato: auto;
	sig: listaanio;
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

vector = array [rango] of listaanio;

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
		mismamarca:=1 + mismamarca(a^.hi, marca) + mismamarca(a^.hd, marca)
		else
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
	if(a = nil) then
	mismamarca2:=0
	else
		if(a^.dato.marca = m) then
		mismamarca2:=contarlista(a^.dato.info)
	else
	if(m < a^.dato.marca) then
	mismamarca2(a^.hi, m)
	else
	mismamarca2(a^.hd, m);
end;

procedure iniciarvector(var v: vector);
var
	i: integer;
begin
	for i:=2015 to 2024 do
	v[i]:=nil;
end; 

procedure agregarAdelante(var L: listaanio; a: auto);
var
  nue: listaanio;
begin
  new(nue);
  nue^.dato:= a;
  nue^.sig:= L;
  L:= nue;
end;

	
procedure agrupar(a: arbol; var v: vector);
begin
	if(a <> nil) then
	begin
		agrupar(a^.hi, v);
		agregaradelante(v[a^.dato.anio], a^.dato);
		agrupar(a^.hd, v);
	end;
end;

function buscarpatente(a: arbol; p: integer): string;
begin
  if a = nil then
    buscarpatente := ' '
  else
  begin
    if a^.dato.patente = p then
      buscarpatente := a^.dato.modelo
    else
    begin
      if p < a^.dato.patente then
        buscarpatente := buscarpatente(a^.hi, p)
      else
        buscarpatente := buscarpatente(a^.hd, p);
    end;
  end;
end;

var
	a: arbol;
	a2: arbol2;
	totalmarca: integer;
	marcaleida: string;
	totalmarca2: integer;
	marcaleida2: string;
	v: vector;
	leerpatente: integer;
begin
	iniciarvector(v);{d}
	a:=nil;
	a2:=nil;
	cargar(a, a2);{a}
	write('ingrese una marca');
	read(marcaleida);{b}
	totalmarca:=mismamarca(a, marcaleida);{b}
	write('total de autos con la misma marca: ' , totalmarca);{b}
	
	read(marcaleida2);{c}
	totalmarca2:=mismamarca2(a2, marcaleida2);{c}
	write(totalmarca2);{c}
	
	agrupar(a, v);{d}
	
	writeln('ingrese una patente');{e}
	read(leerpatente);{e}
	buscarpatente(a, leerpatente);{e}
end.
	
