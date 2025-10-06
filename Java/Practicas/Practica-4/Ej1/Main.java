package tema4.Ej1;
public class Main {
    public static void main(String[] args) {
        Cuadrado cua = new Cuadrado(42, "negro", "azul");
        Rectangulo rec = new Rectangulo(23, 32, "azul", "verde");
        Triangulo t = new Triangulo(10, 20, 30, "rojo", "seudoverde");
        
        System.out.println("Color linea: " + cua.getColor()); 
        System.out.println("Area: " + cua.getLinea()); 
        System.out.println(cua.toString());
        
        System.out.println(t);
    }
    
}
