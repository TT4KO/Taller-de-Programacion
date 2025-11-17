procedure Insercion(var v: vector; dimL: integer);
var
  i, j: integer;
  actual: oficinas;
begin
  for i := 2 to dimL do
  begin
    actual := v[i];
    j := i - 1;
    while (j > 0) and (v[j].codigo > actual.codigo) do
    begin
      v[j+1] := v[j];
      j := j - 1;
    end;
    v[j+1] := actual;
  end;
end;
