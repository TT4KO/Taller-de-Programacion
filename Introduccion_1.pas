program NumAleatorio;
var ale: integer;
begin
  randomize;
  ale := random (100);
  writeln ('El número aleatorio generado es: ', ale);
  readln;
end.
-------------------------------
Modifique el programa para que imprima 20 números aleatorios.

program NumAleatorio;
var 
  ale: integer;
  i: integer;
begin
  randomize;
  for i:=1 to 20 do
  begin
    ale := random (100);
    writeln ('El número aleatorio generado es: ', ale);
  end;
  readln;
end.
