package Estacion_Servicio;
public class Estacion {
    private String direccion;
    private Surtidor[] surtidor;
    private int diml;
    
    public Estacion(String direccion){
        this.direccion = direccion;
        this.diml = 0;
        this.surtidor = new Surtidor[6];
    }
    
    public void agregar(Surtidor s){
        if(diml < 6){
            surtidor[diml] = s;
            diml++;
        }
    }
    
    public int recaudacionmax(){
        int surtidormax = -1;
        double max = -1;
        for(int i=0; i<6; i++){
            Surtidor s = surtidor[i];
            if(s != null){
                double total = s.montotal();
                if(total > max){
                max = total;
                surtidormax = (i+1);
                }
            }       
        }
    return  surtidormax;    
    }   
    
    public int cantsurtidores(){
        int cant = 0;
        for(int i=0; i<6; i++){
            if(surtidor[i] != null){
                cant++;
            }
        }
        return cant;
    }
    
    public String toString(){
        String aux = "Estacion de servicio: " + direccion;
            aux+= " | Cantidad surtidores: " + this.cantsurtidores() + "\n";
            for(int i=0; i<diml; i++){
                aux+="Surtidor" + (i+1) + "\n";
                aux+= surtidor[i].toString() + "\n";
            }
        return aux;
    }
}
