package Parcial;
public class Alumnos {
    private String nombrealumno;
    private int canttareas;
    private int totalnotas;
    
    public Alumnos(String nombrealumno, int canttareas, int totalnotas){
        this.nombrealumno = nombrealumno;
        this.canttareas = 0;
        this.totalnotas = 0;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }
    public int getCanttareas() {
        return canttareas;
    }
    public int getTotalnotas() {
        return totalnotas;
    }
    
    public void setCanttareas(int canttareas) {
        this.canttareas = canttareas;
    }
    public void setTotalnotas(int totalnotas) {
        this.totalnotas = totalnotas;
    }

    
}
