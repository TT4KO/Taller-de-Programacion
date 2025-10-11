package Supermercado;
public class Main {
    public static void main(String[] args) {
       Super s = new Super("los bolitas", "la merced", 2, 3 );
       
       s.registrar(new Producto(1, "fideos", "lays", 3, 800));
       s.registrar(new Producto(2, "papitas", "lays", 5, 1500));
       s.registrar(new Producto(3, "doritos", "pepsico", 2, 2000));
       s.registrar(new Producto(4, "monster", "cocacola", 15, 2800));
       
       
       System.out.println(s.toString());
       System.out.println("================");
       
       System.out.println("Punto b: " + s.mostrar("lays", 1));
       System.out.println("el mayor producto con mas unidades es: " + s.maximo() );
    }  
}
