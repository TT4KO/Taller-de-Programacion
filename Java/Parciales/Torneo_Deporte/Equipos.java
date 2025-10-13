package FULVO;
public class Equipos {
    private String nombreequipo;
    private String lugar;
    private String tecnico;
    
    public Equipos(String nombreequipo, String lugar, String tecnico){
        this.nombreequipo = nombreequipo;
        this.lugar = lugar;
        this.tecnico = tecnico;
    }

    public String getNombreequipo() {
        return nombreequipo;
    }

    public String getLugar() {
        return lugar;
    }

    public String getTecnico() {
        return tecnico;
    }
    
    
}
