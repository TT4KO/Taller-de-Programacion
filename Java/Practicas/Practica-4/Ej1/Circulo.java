package tema4.Ej1;

public class Circulo extends Figuras{
    private double radio;

    public Circulo(double radio, String color, String linea){
        super(color, linea);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double calculararea(){
        return ((getRadio() * getRadio()) * Math.PI );
    }
    public double calcularperimetro(){
        return(2 * Math.PI * getRadio());
    }
}
