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
  //carga del triangulo 
  package tema3;

public class triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private String colorRelleno;
    private String colorLinea;

    // Constructor con parámetros
    public triangulo(double unLadoA, double unLadoB, double unLadoC, String unColorRelleno, String unColorLinea){
        ladoA = unLadoA;
        ladoB = unLadoB;
        ladoC = unLadoC;
        colorRelleno = unColorRelleno;
        colorLinea = unColorLinea;
    }
    
    // Constructor vacío
    public triangulo(){
        
    }

    // Métodos GET
    public double getLadoA(){
        return ladoA;
    }
    public double getLadoB(){
        return ladoB;
    }
    public double getLadoC(){
        return ladoC;
    }
    public String getColorRelleno(){
        return colorRelleno;
    }
    public String getColorLinea(){
        return colorLinea;
    }

    // Métodos SET
    public void setLadoA(double unLadoA){
        ladoA = unLadoA;
    }
    public void setLadoB(double unLadoB){
        ladoB = unLadoB;
    }
    public void setLadoC(double unLadoC){
        ladoC = unLadoC;
    }
    public void setColorRelleno(String unColorRelleno){
        colorRelleno = unColorRelleno;
    }
    public void setColorLinea(String unColorLinea){
        colorLinea = unColorLinea;
    }
    
    public double calcularperimetro(){
        return ladoA + ladoB + ladoC;
    }
    
    public double calcularArea() {
    double s = (ladoA + ladoB + ladoC) / 2.0;
    return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }
}
