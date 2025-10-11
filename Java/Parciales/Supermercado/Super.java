package Supermercado;
public class Super {
    private String nombre;
    private String direccion;
    private Producto[][] gondolas;
    private int g;
    private int e;
    private int proxgondola;
    private int proxestante;
    
    public Super(String nombre, String direccion, int g, int e){
        this.nombre = nombre;
        this.direccion = direccion;
        this.g = g;
        this.e = e;
        this.gondolas = new Producto[g][e];
        this.proxestante = 0;
        this.proxgondola = 0;
    }
    
    public void registrar(Producto p){
        if(proxgondola < g){
            gondolas[proxgondola][proxestante] = p;
            proxestante++;
            if(proxestante == e){
                proxestante = 0;
                proxgondola++;
            }
            else{
                System.out.println("No hay más espacio en el supermercado para exhibir productos.");
            }
        }
    }
    
    public String mostrar(String marcas, int numgondola){
        int i = numgondola - 1;
        boolean encontrado = false;
        String aux = " - ";
            for(int j=0; j<e; j++){
                Producto p = gondolas[i][j];
                if(p != null && p.getMarca().equalsIgnoreCase(marcas)){
                aux += "Producto: " + p.getCodigo() + p.getNombreproducto(); 
                encontrado = true;
                }
                if(!encontrado){
                    aux = "numero de gondola invalido";     
                }
                
            }    
     return aux;       
    }
           
    
    
    public String toString(){
        String s = "Super Mercado: " + nombre + "; " + direccion + "\n";
        for(int i=0; i<g; i++){
            s += "Gondola " + (i+1) + "\n";
            for(int j=0; j<e; j++){                
                Producto p = gondolas[i][j];
                if(p != null){
                s += "Estante " + (j+1) + " " + p.getNombreproducto() + " - " +
                        p.getCodigo() + " - " + p.getMarca() + " - " + 
                        p.getCant() + " - " + p.getPrecio() + "\n";
                }
            }            
        }                   
        return s;
    }
    
    public int maximo(){
        int maximagondola = -1;
        int maxunidades = -1;
        for(int i=0; i<g; i++){
            int total = 0;
            for(int j=0; j<e; j++){
                Producto p = gondolas[i][j];
                if(p != null){
                    total += p.getCant();
                }
                if(total > maxunidades){
                    maxunidades = total;
                    maximagondola = i+1;
                }
            }
        }
        return maximagondola;
    }      
    
}
