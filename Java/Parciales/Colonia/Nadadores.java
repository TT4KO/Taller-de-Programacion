package Parcial;
public class Nadadores extends Informacion {
    private String nombrenadador;
    private double sueldobanero;
    
    public Nadadores(String nombre, double sueldo, double inscripcion, int max, String nombrenadador, double sueldobanero){
        super(nombre, sueldo, inscripcion, max);
        this.nombrenadador = nombrenadador;
        this.sueldobanero = sueldobanero;
    }

    public String getNombrenadador() {
        return nombrenadador;
    }

    public double getSueldobanero() {
        return sueldobanero;
    }

    public void setNombrenadador(String nombrenadador) {
        this.nombrenadador = nombrenadador;
    }

    public void setSueldobanero(double sueldobanero) {
        this.sueldobanero = sueldobanero;
    }
    
    public double ganancias(){
        double ingresos = this.getDiml() * this.getInscripcion();
        double egresos = this.getSueldo() + this.getSueldobanero();
        return ingresos - egresos;
    }
    
    public String toString(){
        String s = "GRUPO NADADORES\n";
        s += super.toString();
        s += "sueldo banero: " + this.sueldobanero;
        s += "ganancia neta: " + this.sueldobanero;
        return s;               
    }
    
}
