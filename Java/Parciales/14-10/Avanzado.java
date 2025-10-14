package Parcial;
public class Avanzado extends Curso{
    private String descripcion;
    
    public Avanzado(String nombre, double costo, String fecha, int max, String desrcipcion){
        super(nombre, costo, fecha, max);
        this.descripcion = descripcion;
    }

    public Alumnos ingresar(){
        int total = 0;
        Alumnos mejor = null;
        int maxpromedio = -1;
        for(int i=0; i<diml; i++){
            total += alumnos[i].getTotalnotas() / alumnos[i].getCanttareas();
            if(total > maxpromedio){
                maxpromedio = total;
                mejor = alumnos[i];
            }
        }
        return mejor;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
