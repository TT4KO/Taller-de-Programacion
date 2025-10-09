package tema5.ej4;
public class Director extends Persona{
    
    private int antiguedad;
    
    public Director(String nombre, int dni, int edad, int antiguedad){
        super(nombre, dni, edad);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
    
    public String toString() {
        return super.toString() + ", Antigüedad: " + antiguedad + " años";
    }
}
