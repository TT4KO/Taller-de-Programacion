package Estacion_Servicio;
public class Surtidor {
    private String combustible;
    private double precio;
    private Venta[] venta;
    private int diml;
    private int dimf;
    
    public Surtidor(String combustible, double precio, int max){
        this.combustible = combustible;
        this.precio = precio;
        this.diml = 0;
        this.dimf = max;
        this.venta = new Venta[max];
    }
    
    public void agregarventa(Venta v){
        if(diml < dimf){
            venta[diml]=v;
            diml++;
        }
    }
    
    public double montotal(){
        double total = 0;
        for(int i=0; i<diml; i++){
            total+= venta[i].getMonto();
        }
        return total;
    }
    
    public String toString(){
        String aux= "Combustible: " + combustible + " Precio: " + precio;
        for(int i=0; i<diml; i++){
            aux += " " + venta[i].toString();
        }
        return aux;
        }
        
    
}
