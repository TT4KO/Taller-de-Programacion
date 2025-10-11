package Torneo;
public class Profesionales extends Sitio{
    private Torneo[] torneo;
    private int diml;
    private int dimf;
    
    public Profesionales(String nombre, String direccionweb, int n){
        super(nombre, direccionweb);
        this.diml = 0;
        this.dimf = n;
        this.torneo = new Torneo[n];
    }
    
    public void agregar(Torneo i){
        if(diml < dimf){
            torneo[diml] = i;
            diml++;
        }
    }
    
    public double cotizacion(){
        double total = 0;
        int canttorneo = 0;       
        for(int i=0; i<diml; i++){                  
                Torneo t = torneo[i];
                total = 1000 + (t.getRecaudado() - t.getMontopremio());
            }                        
        return total;       
    }
    
    public String toString(){
        String aux = "SITIO PROFESIONAL\n";       
        aux+= super.toString();
        aux+= " | Cotizacion total: " + this.cotizacion() + "\n";
        for(int i=0; i< diml; i++){
                Torneo t = torneo[i];
                aux+= "Participantes: " + t.getNombre() + " " + t.getFecha() + "\n";
                               
        }       
        return aux;
    }
}
