package tema3;

public class autor {

    private String nombre;
    private String biografia;
    private String origen;
    
    public autor(String unnombre, String unabiografia, String unorigen){
        nombre = unnombre;
        biografia = unabiografia;
        origen = unorigen;        
    }
    
    public autor(){}
    
    public String getnombre(){
        return nombre;
    }
     public String getbiografia(){
         return biografia;
     }
    public String getorigen(){
        return origen;
    } 
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public void setbiografia(String biografia){
        this.biografia = biografia;
    }
    public void setorigen(String origen){
        this.origen = origen;
    }
    
}
