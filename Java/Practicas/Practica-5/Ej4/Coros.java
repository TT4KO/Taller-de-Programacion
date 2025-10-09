package tema5.ej4;
public abstract class Coros {
    private String nombre;
    private Director director;

    public Coros(String nombre, Director director){
        this.nombre = nombre;
        this.director = director;
    }

    public String getNombrecoro() {
        return nombre;
    }

    
    public Director getDirector() {
        return director;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    
    public abstract void agregarCorista(Coristas unCorista);
    public abstract boolean estalleno();
    public abstract boolean bienformado();
    
    public String toString() {
        return "Coro: " + nombre + ", Director: " + director.getNombre();
    }
}
