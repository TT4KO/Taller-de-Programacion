package tema3;
import PaqueteLectura.GeneradorAleatorio;

public class Habitacion {
    
    private double costopornoche;
    private boolean ocupada;
    private Persona Cliente;
    
    public Habitacion(){
        GeneradorAleatorio.iniciar();
        this.costopornoche = 2000 + GeneradorAleatorio.generarInt(6001);
        this.ocupada = false;
        this.Cliente = null;
    }
    
    public double getcostoponoche(){
        return costopornoche;
    }
    public void setcostopornoche(double costoponoche){
        this.costopornoche = costopornoche;
    }
    
    public boolean isocupada(){
        return ocupada;
    }
    public void setocupada(boolean ocupada){
        this.ocupada = ocupada;
    }
    
    public Persona getcliente(){
        return Cliente;
    }
    public void setcliente(Persona Cliente){
        this.Cliente = Cliente;
        this.ocupada = (Cliente != null);
    }
}
