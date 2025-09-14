function buscarelemento(l: lista; n:integer):boolean;
Var
	aux:lista;
	encontre:boolean;
Begin
	encontre:= false;
	aux:= l;
	while ((aux <> nil) and (encontre = false)) do
	begin
		if (aux^.dato = n) then
		encontre:=true
	else
		aux:= aux^.sig;
end;
	buscarelemento:= encontre;
end;

{pp}
var
  n: integer;
  ok: boolean;
begin
write('ingrese un numero: ');
	readln(n);
	ok:= buscarelemento(l, n);
	if (ok = true) then
	write('el numero si existe')
	else
	write('suerte la proxima');
end.
