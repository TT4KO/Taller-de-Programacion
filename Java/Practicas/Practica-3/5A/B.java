package tema3.Practica5;

import PaqueteLectura.Lector;

public class NewMain {
    public static void main(String[] args) {
        
        System.out.println("ingrese el radio: ");
        double radio = Lector.leerDouble();
        System.out.println("ingrese el el color de relleno: ");
        String color = Lector.leerString();
        System.out.println("ingrese el color de las lineas: ");
        String linea = Lector.leerString();
        
        Circulo c = new Circulo(radio, color, linea);
        
        System.out.println("Perimetro " + c.calcularperimetro());
        System.out.println("Area: " + c.calculararea());
    }
}
