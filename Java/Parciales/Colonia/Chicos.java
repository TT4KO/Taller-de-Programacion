package Parcial;
public class Chicos {
    private String nombre;
    private int telefono;
    private boolean nadar;
    
    public Chicos(String nombre, int telefono, boolean nadar){
        this.nombre = nombre;
        this.telefono = telefono;
        this.nadar = nadar;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public boolean isNadar() {
        return nadar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNadar(boolean nadar) {
        this.nadar = nadar;
    }
    
    public String toString(){
    String estadonado = nadar ? "si" : "no";
    return "Nombre: " + nombre + ", Telefono: " + telefono + " sabe nadar? " + estadonado + "\n"; 
    }
    
}
