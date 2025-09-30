package tema2;
import PaqueteLectura.Lector;
public class work {
    public static void main(String[] args) {
    int diml = 0, dimf = 20;
    Partido [] vector = new Partido [3];//puse 3 porque llenar 20 no da
    
    System.out.println("ingrese un nombre visitante del equipo: " );
    String visitante = Lector.leerString();
    while(!visitante.equals("ZZZ") && diml<dimf){                  
        System.out.println("ingrese un nombre local del equipo: " );
        String local = Lector.leerString();   
        
        System.out.println("ingrese los goles locales: " );
        int golesLocal = Lector.leerInt();
        
        System.out.println("ingrese los goles visitante: " );
        int golesVisitante = Lector.leerInt();
        
        vector[diml] = new Partido(local, visitante, golesLocal, golesVisitante);
        diml++;
        System.out.println("ingrese un nombre visitante del equipo: " );
        visitante = Lector.leerString();
        }
    for(int i=0; i<diml; i++){
        System.out.println("equipo " + vector[i].getLocal() +  " con la cantidad de " + vector[i].getGolesLocal() + 
                " VS " + vector[i].getVisitante() + " con la cantida de goles " + vector[i].getGolesVisitante());
    }

      
    int goles = 0, cantidad = 0;    
    for(int i=0; i<diml; i++){
        if(vector[i].getLocal().equals("river") && vector[i].getGolesLocal() > vector[i].getGolesVisitante()){
                cantidad++;
            }
        if(vector[i].getVisitante().equals("river") && vector[i].getGolesVisitante() > vector[i].getGolesLocal()){
            cantidad++; 
            }    
        if(vector[i].getLocal().equals("boca")){
            goles = vector[i].getGolesLocal();
        }
        }           
    System.out.println("la cantidad de partidos ganador de river fueron: " + cantidad);
    System.out.println("El total de goles de Boca como local fue: " + goles);
    }
}
