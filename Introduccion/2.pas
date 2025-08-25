{Modifique el programa para que imprima N números aleatorios en el rango (A,B), donde N, A y B son números enteros que se leen por teclado}

program NumAleatorio;
var 
  ale, n, a, b: integer;
  i: integer;
begin
  randomize;
  readln(n);
  readln(a);
  readln(b);
  for i := 1 to n do 
  begin
    ale := a + random(b - a + 1); 
    writeln('El número aleatorio generado es: ', ale);
    end;
  readln;
end.
