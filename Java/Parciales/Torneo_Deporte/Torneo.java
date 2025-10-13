package FULVO;
public abstract class Torneo {
    private String nombretorneo;
    private int fecha;
    private double costo;
    private double premio;
    
    public Torneo(String nombretorneo, int fehca, double costo, double premio){
        this.nombretorneo = nombretorneo;
        this.fecha = fecha;
        this.costo = costo;
        this.premio = premio;
    }

    public String getNombretorneo() {
        return nombretorneo;
    }
    public int getFecha() {
        return fecha;
    }
    public double getCosto() {
        return costo;
    }
    public double getPremio() {
        return premio;
    }

    public void setNombretorneo(String nombretorneo) {
        this.nombretorneo = nombretorneo;
    }
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void setPremio(double premio) {
        this.premio = premio;
    }

   

    
    
    public abstract double recaudacion();
    public abstract boolean rentable();
    
    public String toString(){
        String aux = "Nombre del torneo: " + nombretorneo + " Fecha: " + fecha;
        return aux;
    }
    
}
