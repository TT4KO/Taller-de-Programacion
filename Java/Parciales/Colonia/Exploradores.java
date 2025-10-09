package Parcial;
public class Exploradores extends Informacion{
    private double costoalquiler;
    
    public Exploradores(String nombre, double sueldo, double inscripcion, int max, double costoalquiler){
        super(nombre, sueldo, inscripcion, max);
        this.costoalquiler = costoalquiler;
    }

    public double getCostoalquiler() {
        return costoalquiler;
    }

    public void setCostoalquiler(double costoalquiler) {
        this.costoalquiler = costoalquiler;
    }

    public double ganancias(){
        double ingresos = this.getDiml() + this.getInscripcion();
        double egresos = this.getSueldo() + this.getCostoalquiler();
        return ingresos - egresos;
    }
    
    public String toString(){
        String s = "GRUPO EXPLORADORES";
        s+= super.toString();
        s+= "costo por alquiler: " + this.costoalquiler;
        s+= "ganancias: " + this.ganancias();
        return s;
    }
}
