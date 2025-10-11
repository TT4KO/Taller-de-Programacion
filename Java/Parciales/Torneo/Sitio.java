package Torneo;
public abstract class Sitio {
        private String nombre;
        private String direccionweb;
        private int cantusuarios;
        
    public Sitio(String nombre, String direccionweb){
        this.nombre = nombre;
        this.direccionweb = direccionweb;
        this.cantusuarios = 0;
    }

    public String getNombre() {        return nombre;    }

    public String getDireccionweb() {        return direccionweb;    }

    public int getCant() {        return cantusuarios;    }

    public void setNombre(String nombre) {        this.nombre = nombre;   }

    public void setDireccionweb(String direccionweb) {       this.direccionweb = direccionweb;   }

    public void setCant(int cant) {        this.cantusuarios = cant;    }
    
    public abstract double cotizacion();
    
    public String toString(){
        String aux = " | Nombre: " + nombre + "  | Direccion: " + direccionweb + " | Cantidad usuarios: " + cantusuarios;
        
        return aux;
    }
}
