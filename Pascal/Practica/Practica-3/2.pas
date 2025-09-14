program iasd;
type
tfecha = record
	dia: integer;
	mes: integer;
	anio: integer;
end;

venta = record
	codigo: integer;
	fecha: tfecha;
	cantidad: integer;
end;

lista = ^nodo;
	nodo = record
	dato: venta;
	sig: lista;
end;
 
arbol = ^nodo4;
	nodo4 =  record
	dato: venta;
	hd: arbol;
	hi: arbol;
end;

producto = record
	codigo: integer;
	total: integer;
end;

arbol2 = ^nodo2;
	nodo2 = record
	dato: producto;
	hd: arbol2;
	hi: arbol2;
end;

productos2 = record
	codigo: integer;
	ventas: lista;
end;

arbol3 = ^nodo3;
	nodo3 = record
	dato: productos2;
	hd: arbol3;
	hi: arbol3;
end;

procedure leerfecha(var f: tfecha);
begin
	f.dia:=random(30) + 1;
	f.mes:=random(12) + 1;
	f.anio:=2020 + random(6);
end;

procedure leer(var v: venta);
begin
	v.codigo:=random(20);
	if (v.codigo <> 0) then
	begin
		v.cantidad:=random(50) + 1;
		leerfecha(v.fecha);
	end;
end;

Procedure agregar (var a:arbol; v: venta);
Begin
  if (a = nil) then
   begin
      new(A);
      a^.dato:= v; 
      a^.HI:= nil; 
      a^.HD:= nil;
   end
   else
    if (v.codigo < a^.dato.codigo) then 
		agregar(a^.HI,	v)
    else 
		agregar (a^.HD, v);
End;

procedure cargar(var a: arbol);
var
	v: venta;
begin
	leer(v);
	while (v.codigo <> 0) do
	begin
		agregar(a, v);
		leer(v);
	end;
end;
	
procedure mostrar(a: arbol);
begin
	if(a <> nil) then
	begin
		mostrar(a^.hi);
		writeln('codigo: ');
		write(a^.dato.codigo);
		writeln('mostrando fecha: ');
		write(a^.dato.fecha.dia, a^.dato.fecha.mes, a^.dato.fecha.anio);
		writeln('mostrando cantidad: ' );
		write(a^.dato.cantidad);
	mostrar(a^.HD);
	end;
end;

procedure agregar2(var a: arbol2; cod: integer; cant: integer);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=cod;
		a^.dato.total:=cant;
		a^.hi := nil;
		a^.hd :=nil;
	end
	else 
	if(cod < a^.dato.codigo) then
		agregar2(a^.hi, cod, cant)
	else
	if(cod > a^.dato.codigo) then
		agregar2(a^.hd, cod, cant)
	else
	a^.dato.total:=a^.dato.total + cant;
end;

procedure nuevoarbol(var a2: arbol2; a: arbol);
begin
	if(a <> nil) then
	begin
		nuevoarbol(a2, a^.hi);
		agregar2(a2, a^.dato.codigo, a^.dato.cantidad);
		nuevoarbol(a2, a^.hd);
	end;
end;

procedure mostrar2(a2: arbol2);
begin
	if(a2 <> nil) then
	begin
		mostrar2(a2^.hi);
		writeln('codigo: ');
		write(a2^.dato.codigo);
		writeln('mostrando total: ' );
		write(a2^.dato.total);
	mostrar2(a2^.HD);
	end;
end;

procedure agregarLista(var L: lista; v: venta);
var
  nue: lista;
begin
  new(nue);
  nue^.dato := v;
  nue^.sig := L;
  L := nue;
end;

procedure agregarproducto(var a: arbol3; v: venta);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=v.codigo;
		a^.dato.ventas:=nil;
		agregarlista(a^.dato.ventas, v);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
	if(v.codigo < a^.dato.codigo) then
	agregarproducto(a^.hi, v)
	else
	if(v.codigo > a^.dato.codigo) then
	agregarproducto(a^.hd, v)
	else
	agregarlista(a^.dato.ventas, v);
end;

procedure arboldelista(var a3: arbol3; a: arbol);
begin
	if(a <> nil) then
	begin
	arboldelista(a3, a^.hi);
	agregarproducto(a3, a^.dato);
	arboldelista(a3, a^.hd);
	end;
end;

procedure mostrarventas(l: lista);
begin
	while(l <> nil) do
	begin
		write(l^.dato.cantidad);
		write(L^.dato.fecha.dia, '/', L^.dato.fecha.mes, '/', L^.dato.fecha.anio);
		l:=l^.sig;
	end;
end;

procedure mostrar3(a3: arbol3);
begin
	if(a3 <> nil) then
	begin
		mostrar3(a3^.hi);
		writeln('codigo: ');
		write(a3^.dato.codigo);
		writeln('mostrando total: ' );
		mostrarventas(a3^.dato.ventas);
	mostrar3(a3^.HD);
	end;
end;

function totalproductos(a: arbol; f: tfecha): integer;
begin
	if(a <> nil) then
	totalproductos:=0
	else
	begin
			if(a^.dato.fecha.dia = f.dia) and
			(a^.dato.fecha.mes = f.mes) and
			(a^.dato.fecha.anio = f.anio) then
			totalproductos:=a^.dato.cantidad
	else
	totalproductos:=0;
	totalproductos:=totalproductos + totalproductos(a^.hi, f) + totalproductos(a^.hd, f);
	end;
end;

procedure mayor(a: arbol2; var codmax, maxventas: integer);
begin
	if(a <> nil) then
	begin
		mayor(a^.hi, codmax, maxventas);
		if(a^.dato.total > maxventas) then
		begin
			maxventas:=a^.dato.total;
			codmax:=a^.dato.codigo;
		end;
		mayor(a^.hd, codmax, maxventas);
	end;
end;

procedure mayorventa(a: arbol2);
var
	maxventas, codmax: integer;
begin
	maxventas:=-1;
	codmax:=-1;
	mayor(a, maxventas, codmax);
	write('el codigo maximo es: ' , codmax);
end;

var
  a: arbol;
  a2: arbol2;
  a3: arbol3;
  f: tfecha;
  total: integer;
begin
  randomize;
  a := nil;
  a2:= nil;
  a3:= nil;
  writeln('cargando lista...');
  cargar(a);{ai}
  writeln('mostrandolista...');
  mostrar(a);{ai}
  
  nuevoarbol(a2, a);{aii}
  mostrar2(a2);{aii}
  
  arboldelista(a3, a);{aiii}
  mostrar3(a3);{aiii}
  
  writeln(' incisos b ');
  readln(f.dia);{b}
  readln(f.mes);{b}
  readln(f.anio);{b}
  total:=totalproductos(a, f);{b}
  write('el total es: ' , total);{b}
  mayorventa(a2);{c}
end.
