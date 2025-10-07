package tema4.ej3;

public class Trabajador extends Persona{
    private String tarea;

    public Trabajador(String nombre, int dni, int edad, String tarea){
        super(nombre, dni, edad);
        setTarea(tarea);
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    public String toString(){
        return super.toString() + " soy " + getTarea();
    }
}
