package tema3.Practica5;
public class NewMain {
    public static void main(String[] args) {
        Circulo c = new Circulo(5.0, "rojo", "negro");
        
        System.out.println("radio: " + c.getRadio());
        System.out.println("Perimetro " + c.calcularperimetro());
        System.out.println("Area: " + c.calculararea());
    }
}
