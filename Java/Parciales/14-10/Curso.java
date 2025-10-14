package Parcial;
public abstract class Curso {
    private String nombre;
    private double costo;
    private String fecha;
    protected Alumnos[] alumnos;
    protected int diml;
    protected int dimf;
    
    public Curso(String nombre, double costo, String fecha, int max){
        this.nombre = nombre;
        this.costo = costo;
        this.fecha = fecha;
        this.diml = 0;
        this.dimf = max;
        this.alumnos = new Alumnos[max];
    }
    
    public int agregar(Alumnos a){
        if(diml < dimf){
            alumnos[diml] = a;
            diml++;         
        }
        return diml;
    }
    
    public Alumnos obetener(int a){
        return alumnos[a-1];
    }
    
    public void actualizar(String nombre, int x){
        for(int i=0; i<diml; i++){
            Alumnos a = alumnos[i];
            if(a.getNombrealumno().equalsIgnoreCase(nombre)){
                a.setCanttareas(a.getCanttareas() + 1);
                a.setTotalnotas(a.getTotalnotas() + x);
            }
        }
    }
    
    public abstract Alumnos ingresar();

    public String getNombre() {
        return nombre;
    }

  
    
}
