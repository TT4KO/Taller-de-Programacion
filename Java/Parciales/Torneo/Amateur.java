package Torneo;
public class Amateur extends Sitio{
    private int canttorneos;
    private int cantclicks;
    
    public Amateur(String nombre, String direccionweb){
        super(nombre, direccionweb);
        this.cantclicks = 0;
        this.canttorneos = 0;
        
    }

    public int getCanttorneos() {
        return canttorneos;
    }

    public int getCantclicks() {
        return cantclicks;
    }

    public void setCanttorneos(int canttorneos) {
        this.canttorneos = canttorneos;
    }

    public void setCantclicks(int cantclicks) {
        this.cantclicks = cantclicks;
    }
    
    public double cotizacion(){
        return(10 * cantclicks) +(50 * this.getCant());
    }
    
    public void registraramateur(int clicksnuevos){
        cantclicks += clicksnuevos;
        canttorneos++;
    }
    
    
    public String toString(){
        String aux = "SITIO AMATEUR\n";
        aux+= super.toString() + " | Cotizacion total: " +this.cotizacion();
        return aux;
    }
}
