{Modifique el programa para que imprima númerosaleatorios en el rango (A,B) hasta que se genere unvalor igual a F, el cual no debe imprimirse. F, A y B son números enteros que se leen por teclado}

program NumAleatorio;
var 
  ale, f, a, b: integer;
  i: integer;
begin
  randomize;
  readln(f);
  readln(a);
  readln(b);
  repeat
        ale := a + random(b - a + 1); 
        if (ale <> f) then
        writeln('El número aleatorio generado es: ', ale);
    until ale = f;
  writeln;
  write('el numero ya se genero' , f);
  readln;
end.
