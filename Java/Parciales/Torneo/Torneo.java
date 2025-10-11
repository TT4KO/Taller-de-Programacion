package Torneo;
public class Torneo {
    private String nombre;
    private int fecha;
    private double recaudado;
    private double montopremio;
    
    public Torneo(String nombre, int fecha, double recaudado, double montopremio){
        this.nombre = nombre;
        this.fecha = fecha;
        this.recaudado = recaudado;
        this.montopremio = montopremio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFecha() {
        return fecha;
    }

    public double getRecaudado() {
        return recaudado;
    }

    public double getMontopremio() {
        return montopremio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public void setRecaudado(double recaudado) {
        this.recaudado = recaudado;
    }

    public void setMontopremio(double montopremio) {
        this.montopremio = montopremio;
    }
    
}
