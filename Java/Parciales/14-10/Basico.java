package Parcial;
public class Basico extends Curso{
    
    public Basico(String nombre, double costo, String fecha, int max){
        super(nombre, costo, fecha, max);
    }
    
    public Alumnos ingresar(){
        Alumnos mejor = null;
        int maxtareas = -1;
        for(int i=0; i<diml; i++){
            if(alumnos[i].getCanttareas() > maxtareas){
            maxtareas = alumnos[i].getCanttareas();
            mejor = alumnos[i];
            }
        }
        return mejor;
    }
    
    
}
