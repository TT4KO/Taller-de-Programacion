package tema3;
import PaqueteLectura.Lector;
public class main {

    public static void main(String[] args) {
      
    System.out.println("ingrese el lado a: " );
    double ladoa = Lector.leerInt();
    System.out.println("ingrese el lado b: " );
    double ladob = Lector.leerInt();
    System.out.println("ingrese el lado c: " );
    double ladoc = Lector.leerInt();
    System.out.println("ingrese un color de relleno: " );
    String color = Lector.leerString();
    System.out.println("ingrese un color de linea: " );
    String linea = Lector.leerString();
    
    triangulo t = new triangulo(ladoa, ladob, ladoc, color, linea);
    
    System.out.println("Triángulo creado:");
        System.out.println("Lado A: " + t.getLadoA());
        System.out.println("Lado B: " + t.getLadoB());
        System.out.println("Lado C: " + t.getLadoC());
        System.out.println("Color de relleno: " + t.getColorRelleno());
        System.out.println("Color de línea: " + t.getColorLinea());
    
    double Perimetro = t.calcularperimetro();
    System.out.print("El perimetro es: " + Perimetro);
    double area = t.calcularArea();
    System.out.println("el area del circulo es: " + area);   
    }   
}

-----------------------------------------------------------------------------
