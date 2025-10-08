package tema5.ej2;
public class Auto {
    private String dueno;
    private String patente;
    
    public Auto(String dueno, String patente){
        this.dueno = dueno;
        this.patente = patente;
    }

    public String getDueno() {
        return dueno;
    }

    public String getPatente() {
        return patente;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public String toString() {
        return "Auto [Dueño: " + dueno + ", Patente: " + patente + "]";
    }
}
