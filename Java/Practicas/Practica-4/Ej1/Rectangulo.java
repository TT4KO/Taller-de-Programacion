package tema4.Ej1;

public class Rectangulo extends Figuras {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura, String color, String linea){
        super(color, linea);
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double calculararea(){
        return (getBase() * getAltura());
    }
    public double calcularperimetro(){
        return ((getBase()* 2 + (getBase() * 2)));
    }
    
    public String toString(){
        return("Rectangulo: Base:" + base + " altura: " + altura + " | " + super.toString());
    }
    
}
