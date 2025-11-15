program iads;
type
producto = record
	codigo: integer;
	cantidad: integer;
	monto: real;
end;

venta = record
	codigoventa: integer;
	codigoproducto: integer;
	cantidad2: integer;
	precio: real;
end;


arbol = ^nodo2;
	nodo2 = record
	dato: producto;
	hi, hd: arbol;
end;

procedure leerventa(var v: venta);
begin
	read(v.codigoventa);
	if (v.codigoventa <> - 1) then
	begin
		read(v.codigoproducto);
		read(v.cantidad2);
		read(v.precio);
	end;
end;

procedure agregar(var a: arbol; v: venta);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=v.codigoproducto;
		a^.dato.cantidad:=v.cantidad2;
		a^.dato.monto:=v.cantidad2 * v.precio;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(v.codigoproducto < a^.dato.codigo) then
		agregar(a^.hi, v)
	else
		agregar(a^.hd, v)
end;
		
procedure cargar(var a: arbol);
var
	v: venta;
begin
	leerventa(v);
	while(v.codigoventa <> -1) do
	begin
		agregar(a, v);
		leerventa(v);
	end;
end;

procedure imprimir(a: arbol);
begin
	if(a <> nil) then
	begin
		imprimir(a^.hi);
		write(a^.dato.codigo, a^.dato.cantidad, a^.dato.monto);
		imprimir(a^.hd);
	end;
end;

procedure maximo(var max, codmax: integer; a: arbol);
begin
	if(a <> nil) then
	begin
		maximo(max, codmax, a^.hi);
		if(a^.dato.cantidad > max) then
		begin
			max:=a^.dato.cantidad;
			codmax:=a^.dato.codigo;
		end;
		maximo(max, codmax, a^.hd);
	end;
end;

function incisod(a: arbol; num: integer):integer;
begin
	if(a = nil) then
		incisod:=0
	else
		if(a^.dato.cantidad < num) then
		incisod:=1 + incisod(a^.hi, num) + incisod(a^.hd, num)
	else
		incisod:=incisod(a^.hi, num) + incisod(a^.hd, num);
end;

function incisoe(a: arbol; cod1, cod2: real): real;
begin
	if(a = nil) then
	incisoe:=0
	else
		if(a^.dato.codigo <= cod1) then
		incisoe:=incisoe(a^.hd, cod1, cod2)
	else
		if(a^.dato.codigo >= cod2) then
		incisoe:=incisoe(a^.hi, cod1, cod2)
	else
		incisoe:=a^.dato.monto + incisoe(a^.hi, cod1, cod2) + incisoe(a^.hd, cod1, cod2)
end;


var
	a: arbol;
	max, codmax, num, cant: integer;
	cod1, cod2: real;
begin
	max:=-1;
	codmax:=-1;
	a:=nil;
	cargar(a);
	imprimir(a);{b}
	
	maximo(max, codmax, a);{c}
	write(codmax);{c}
	
	read(num);{d}
	cant:=incisod(a, num);{d}
	write(cant);{d}
	
	read(cod1);
	read(cod2);
	incisoe(a, cod1, cod2);
end.
