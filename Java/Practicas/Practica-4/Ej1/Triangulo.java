package tema4.Ej1;

public class Triangulo extends Figuras{
    private double ladoa;
    private double ladob;
    private double ladoc;

    public Triangulo(double ladoa, double ladob, double ladoc, String color, String linea){
        super(color, linea);
        setLadoa(ladoa);
        setLadob(ladob);
        setLadoc(ladoc);
    }

    public double getLadoa() {
        return ladoa;
    }

    public double getLadob() {
        return ladob;
    }

    public double getLadoc() {
        return ladoc;
    }

    public void setLadoa(double ladoa) {
        this.ladoa = ladoa;
    }

    public void setLadob(double ladob) {
        this.ladob = ladob;
    }

    public void setLadoc(double ladoc) {
        this.ladoc = ladoc;
    }
    
    public double calculararea(){
        return ((getLadoa() * getLadob()) / 2);
    }
    
    public double calcularperimetro(){
        return(getLadoa() + getLadob() + getLadoc());
    }
    public String toString(){
        return ("Triangulo y sus lados: " + ladoa + " , " + ladob + " , " + ladoc + " | " + 
                super.toString()); 
    }
}
