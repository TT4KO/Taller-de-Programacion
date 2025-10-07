package tema4.ej2;

public class Jugador extends Empleado{
    private int partidos;
    private int goles;
    
    public Jugador(int partidos, int goles, String nombre, double sueldo, int antiguedad){
        super(nombre, sueldo, antiguedad);
        setPartidos(partidos);
        setGoles(goles);
    }

  
    
    public int getPartidos() {
        return partidos;
    }

    public int getGoles() {
        return goles;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    
    
    public double calcularefectividad(){
        double promedio = goles / partidos; 
        return promedio;
    }
    
    public double calcularsueldoacobrar(){
        double sueldobase = getSueldo();
        double sueldo = sueldobase + (sueldobase * 0.10 * getAntiguedad());
        
        if(calcularefectividad() > 0.5){
            sueldo += sueldobase;
        }
        return sueldo;
    }
}
