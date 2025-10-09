package tema5.ej4;
public class Corohileras extends Coros{
    private Coristas[][] corista;
    private int filas;
    private int columnas;
    private int dimlfilas;
    private int dimlcolumnas;
    
    public Corohileras(String nombre, Director director, int cantfilas, int cantcolumnas){
        super(nombre, director);
        this.filas = cantfilas;
        this.columnas = cantcolumnas;
        this.corista = new Coristas[cantfilas][cantcolumnas];
        this.dimlfilas = 0;
        this.dimlcolumnas = 0;
    }
    
    public void agregarCorista(Coristas co){
        if(dimlfilas < filas){
            corista[dimlfilas][dimlcolumnas]=co;
            dimlcolumnas++;
            if(dimlcolumnas < columnas){
                dimlcolumnas = 0;
                dimlfilas++;
            }
        }    
    }

    public boolean bienformado(){
        if(!this.estalleno()){
            return false;
        }
        for(int i=0; i<filas; i++){
            int tonobase = corista[i][0].getTono();
            for(int j=0; j<columnas; j++){
               if(corista[i][j].getTono() != tonobase){
                   return false;
               }
            }
        }
        for(int i=0; i<filas; i++){
            int tonoactual = corista[i][0].getTono();
            int tonosiguiente = corista[i+1][0].getTono();
            if(tonoactual < tonosiguiente){
                return false;
            }
        }
        return true;
    }
    
    public Coristas[][] getCorista() {
        return corista;
    }
    
    public boolean estalleno(){
        return dimlfilas == filas;
    }
    
}
