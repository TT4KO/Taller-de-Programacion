Cuando pide retornar una lista buscando algo

procedure nuevalista(l: lista; var l2: listacompra)
begin
    if(l <> nil)
      adelante(l2, l^.dato)
      l:=l^.sig;
    end;
end;  
function crearnuevalista(a: arbol; codgame: integer; var l2: lista):listacompra
begin
    if(a <> nil) then
    begin
      crearnuevalista:=nil
      if(a^.dato.codigo = codgame)
      nuevalista(a^.dato.info, l2)
    end
    else
      if(a^.dato.codido < codgame)
        crearnuevalista(a^.hi, codgame, l2)
      else
        crearnuevalista(a^.hd, codgame, l2)
end;
PP
var
  codgame: integer;
  l2: listacompra;
  a: arbol;
begin
    l2:=nil
    read(codgame)
    crearnuevalista(a, codgame, l2)
end.
-----------------------------------------------------------------------------------------------------
