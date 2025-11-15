program iads;
type
tfecha = record
	dia: integer;
	mes: integer;
	anio: integer;
end;
finales = record 
	legajo: integer;
	codigo: integer;
	fecha: tfecha;
	nota: integer
end;

informacion = record
	codigo2: integer;
	nota2: integer;
end;

lista =  ^nodo2;
	nodo2 = record
	dato: informacion;
	sig: lista;
end;

alumno = record
	legajo2: integer;
	info: lista;
end;

arbol = ^nodo;
	nodo = record
	dato: alumno;
	hd: arbol;
	hi: arbol;
end;

procedure leerfecha(var t: tfecha);
begin
	read(t.dia);
	read(t.mes);
	read(t.anio);
end;

procedure leer(var f: finales);
begin
	read(f.legajo);
	if(f.legajo <> 0) then
	begin
		read(f.codigo);
		leerfecha(f.fecha);
		read(f.nota);
	end;	
end;

procedure adelante(var l: lista; inf: informacion);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := inf;
  nue^.sig := l;
  l := nue;
end;

procedure agregar(var a: arbol; f: finales);
var
	inf: informacion;
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.legajo2:=f.legajo;
		a^.dato.info:=nil;
		inf.codigo2:=f.codigo;
		inf.nota2:=f.nota;
		adelante(a^.dato.info, inf);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(f.legajo < a^.dato.legajo2) then
		agregar(a^.hi, f)
	else
		if(f.legajo > a^.dato.legajo2) then
		agregar(a^.hd, f) 
	else
	begin
		inf.codigo2:=f.codigo;
		inf.nota2:=f.nota;
		adelante(a^.dato.info, inf)
	end;
end;

procedure cargar(var a: arbol);
var
	f: finales;
begin
	leer(f);
	while(f.legajo <> 0) do
	begin
		agregar(a, f);
		leer(f);
	end;
end;

function numeroimpar(a: arbol): integer;
begin
	if(a = nil) then
	numeroimpar:=0
	else
	begin
		if (a^.dato.legajo2 mod 2 = 1) then
			numeroimpar:=numeroimpar(a^.hi) + numeroimpar(a^.hd) + 1
		else
			numeroimpar:=numeroimpar(a^.hd) + numeroimpar(a^.hi);
	end;
end;

function comprobar(l: lista): integer;
var
	cant: integer;
begin
	cant:=0;
	while(l <> nil) do
	begin
		if (l^.dato.nota2 > 4) then
		cant:=cant + 1;
		l:=l^.sig;
	end;
	comprobar:=cant;
end;

procedure puntoc(a: arbol);
var
	cant: integer;
begin
	if(a <> nil) then
	begin
		puntoc(a^.hi);
		
		cant:=comprobar(a^.dato.info);
		write(a^.dato.legajo2, cant);
		
		puntoc(a^.hd);
	end;
end;

function promediar(l: lista): real;
var
	suma, cant: real;
begin
	suma:=0;
	cant:=0;
	while(l <> nil) do
	begin
		suma:=suma + l^.dato.nota2;
		cant:=cant + 1;
		l:=l^.sig;
	end;
	if(cant = 0) then
		promediar:=0
	else
		promediar:=suma/cant;
end;

procedure puntod(a: arbol; num: real);
var
	prom: real;
begin
	if(a <> nil) then
	begin
		puntod(a^.hi, num);
		prom:=promediar(a^.dato.info);
		if(prom > num) then
		write(a^.dato.legajo2, prom);
		
		puntod(a^.hd, num);
	end;
end;

	

var
	a: arbol;
	num: real;
begin
	a:=nil;
	cargar(a);
	
	numeroimpar(a);{b}
	write(numeroimpar(a));{b}
	
	puntoc(a);{c}
	
	read(num);
	puntod(a, num);
end.
