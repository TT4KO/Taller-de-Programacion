function fijarse(v: vector; diml, cod: integer): integer;
var
	pri, ult, medio: integer;
begin
	pri:=1;
	ult:=diml;
	fijarse:=0;
	while(pri <=ult) and (fijarse = 0) do
	begin
		medio:=(pri + ult) div 2;
		if (v[medio].codigo = cod) then
		fijarse:=medio
		else
		if(v[medio].codigo > cod) then
		ult:=medio - 1 
		else
		pri:=medio + 1;
	end;
end;
