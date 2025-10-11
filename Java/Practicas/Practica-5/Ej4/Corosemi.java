package tema5.ej4;
public class CoroSemi extends Coros{
    private Coristas[] coristas;
    private int diml;
    private int dimf;
    
    public CoroSemi(String nombre, Director director, int cant){
        super(nombre, director);
        this.dimf = cant;
        this.diml = 0;
        this.coristas = new Coristas[cant];
    }
    
    public void agregarCorista(Coristas uncorista){
        if(diml < dimf){
            coristas[diml]= uncorista;
            diml++;
        }
    }
    
    public boolean bienformado(){
        if(!this.estalleno()){
            return false;
        }
        for(int i=0; i<diml - 1; i++){
        int tonoactual = coristas[i].getTono();
        int tonosiguiente = coristas[i+1].getTono();
        if(tonoactual < tonosiguiente){
            return false;
        }       
    }
    return true;
}
