function comprasrealizadas(l: listacompras; num: integer):integer;
begin
	if(l = nil) then
	comprasrealizadas:=0;
	begin	
		if(l^.dato.mescompra = num) then
		comprasrealizadas:=comprasrealizadas(l^.sig, num) + 1
		else
		comprasrealizadas:=comprasrealizadas(l^.sig, num)		
	end;
end;

PP
var
  l2: listacompras;
  mesbuscado: integer;
begin
    writeln('ingresa un mes: ');
	  read(mesbuscado);
	  totalcompras:=comprasrealizadas(l2, mesbuscado);
	  write('compras por mes son ' , mesbuscado , 'y la cantidad' , totalcompras);
end.
