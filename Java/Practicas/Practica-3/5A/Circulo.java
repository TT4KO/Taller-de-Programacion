package tema3.Practica5;

public class Circulo {
    private double radio;
    private String color;
    private String linea;
    
    public Circulo(double radio, String color, String linea) {
        this.radio = radio;
        this.color = color;
        this.linea = linea;
    }
    
    public Circulo(){}
    
    public double getRadio() {
        return radio;
    }

    public String getColor() {
        return color;
    }

    public String getLinea() {
        return linea;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    
    public double calcularperimetro(){
        return 2.0 * radio * Math.PI;        
    }
    

    public double calculararea(){
        return Math.PI * radio * radio;
    }
}
