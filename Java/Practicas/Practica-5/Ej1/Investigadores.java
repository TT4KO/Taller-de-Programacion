package tema5;
public class Investigadores{
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio[] subsidio;
    private int cantsubsidios = 0;
    
    private Investigadores(String nombre, int categoria, String especialidad){
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
        this.subsidio = new Subsidio[5];
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void agregarsubsidio(Subsidio s){
        if(cantsubsidios < 5){
            subsidio[cantsubsidios] = s;
            cantsubsidios++;
        }
    }
    
   public double getmontototalsubsidio(){
       double total = 0;
       for(int i=0; i<cantsubsidios; i++){
           if(subsidio[i].isEntregado()){
               total += subsidio[i].getMontopedido();
           }
       }
       return total;
   }
   
}
