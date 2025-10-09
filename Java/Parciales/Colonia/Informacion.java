package Parcial;
public abstract class Informacion {
    private String nombre;
    private double sueldo;
    private double inscripcion;
    private Chicos[] chicos;
    private int diml, dimf;
    
    public Informacion(String nombre, double sueldo, double inscripcion, int max){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.inscripcion = inscripcion;
        this.dimf = max;
        this.diml = 0;
        this.chicos = new Chicos[max];
    }
    public void agregar(Chicos c){
        if(diml < dimf){
            chicos[diml] = c;
            diml++;
        }
    }
    
    public String toString(){
        String s = "";
        s += "Instructor: " + this.nombre;
        s += " incriptos " + this.getDiml() + " / " + this.dimf + "\n";
        s += "Costo inscripcion: " + this.inscripcion + "\n" ;
        s += "sueldo instructor: " + sueldo + "\n";
        s += "lista de chicos: \n" + "\n";
        for(int i=0; i<this.diml; i++){
            s+=this.chicos[i].toString();
        }
        return s;
    }
    
    public abstract double ganancias();
     
    public boolean rentable(){
        return this.ganancias() > 50000;        
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public double getInscripcion() {
        return inscripcion;
    }

    public Chicos[] getChicos() {
        return chicos;
    }

    public int getDiml() {
        return diml;
    }

    public int getDimf() {
        return dimf;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setInscripcion(double inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setChicos(Chicos[] chicos) {
        this.chicos = chicos;
    }

    public void setDiml(int diml) {
        this.diml = diml;
    }

    public void setDimf(int dimf) {
        this.dimf = dimf;
    }
    
    
}
