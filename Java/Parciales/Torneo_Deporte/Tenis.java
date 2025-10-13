package FULVO;
public class Tenis extends Torneo{
    private int cantjugadores;
    private String superficie;
    
    public Tenis(String nombretorneo, int fecha, double costo, double premio, int cantjugadores, String superficie){
        super(nombretorneo, fecha, costo, premio);
        this.cantjugadores = cantjugadores;
        this.superficie = superficie;
    }

    public int getCantjugadores() {
        return cantjugadores;
    }
    public String getSuperficie() {
        return superficie;
    }

    public void setCantjugadores(int cantjugadores) {
        this.cantjugadores = cantjugadores;
    }
    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }
        
    
    
    public double recaudacion(){
        return cantjugadores * getCosto();
    }
    
    public boolean rentable(){
         if(this.recaudacion() > (getPremio() * 2)){
            return true;
        }else{
            return false;
        }
    }   
    
    public String toString(){
        String aux = super.toString() + " Monto recaudado: " + this.recaudacion() + " Es rentable?: " + this.rentable();
        return aux;
    }
}
