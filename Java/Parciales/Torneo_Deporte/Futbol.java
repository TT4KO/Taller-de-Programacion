package FULVO;
public class Futbol extends Torneo{  
    private Equipos[] equipos;
    private int diml;
    private int dimf;
    
    public Futbol(String nombretorneo, int fecha, double costo, double premio, int max){
        super(nombretorneo, fecha, costo, premio);
        this.diml = 0;
        this.dimf = max;
        this.equipos = new Equipos[max];       
    }
    
    public void agregar(Equipos e){
        if(diml < dimf){
            equipos[diml] = e;
            diml++;
        }
    }
   
    public double recaudacion(){
            return (diml * 11) * getCosto();
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
