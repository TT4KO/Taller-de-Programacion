package tema5;
public class Proyectos {
    private String nombre;
    private int codigo;
    private String nombredirector;
    private Investigadores[] investigadores;
    private int cantinvestigadores = 0;
    
    public Proyectos(String nombre, int codigo, String nombredirector){
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombredirector = nombredirector;
        this.investigadores = new Investigadores[50];      
    }

    public void agregarinvestigador(Investigadores i){
        if(cantinvestigadores < 50){
            investigadores[cantinvestigadores] = i;
            cantinvestigadores++;
        }
    }
    
    public double dinerototalotorgado(){
        double total = 0;
        for(int i=0; i<cantinvestigadores; i++){
            total += investigadores[i].getmontototalsubsidio();
        }
        return total;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombredirector() {
        return nombredirector;
    }

    public Investigadores[] getInvestigadores() {
        return investigadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombredirector(String nombredirector) {
        this.nombredirector = nombredirector;
    }

    public void setInvestigadores(Investigadores[] investigadores) {
        this.investigadores = investigadores;
    }
    
    
}
