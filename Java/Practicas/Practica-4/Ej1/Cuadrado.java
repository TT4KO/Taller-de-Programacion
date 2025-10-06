package tema4.Ej1;


public class Cuadrado extends Figuras {
    private double lado;
    
    public Cuadrado(double lado, String color, String linea){
        super(color, linea);
        setLado(lado);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    public double calculararea(){
        return(getLado() * getLado());
    }
    
    public double calcularperimetro(){
        return (getLado()*4);
    }
    
    public String toString(){
        String aux = super.toString();
        return aux;
    }
}
