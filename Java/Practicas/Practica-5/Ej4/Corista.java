package tema5.ej4;
public class Coristas extends Persona{
    private int tono;
    
    public Coristas(String nombre, int dni, int edad, int tono){
        super(nombre, dni, edad);
        this.tono = tono;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }

    
}
