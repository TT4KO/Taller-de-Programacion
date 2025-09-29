package tema2;
import PaqueteLectura.GeneradorAleatorio;
public class work {
    public static void main(String[] args) {
        int dl = 0, df = 15;
        int i;
        Persona [] vector = new Persona[df];
        int cantedad = 0;
        Persona p = new Persona();
        
        GeneradorAleatorio.iniciar();
        
        int edad = GeneradorAleatorio.generarInt(100);
        while(edad !=0 && dl < df){
            if(edad > 65){
                cantedad++;
            }
            String nombre = GeneradorAleatorio.generarString(5);
            int dni = 1000000 + GeneradorAleatorio.generarInt(9000000);
            vector[dl] = new Persona(nombre, dni, edad);
            dl++;
            
            edad = GeneradorAleatorio.generarInt(100);
        }
        
        System.out.println("Persona almacenada");
        for(i=0; i<dl; i++){
            System.out.println(vector[i].toString());
        }
        if(dl > 0){
            Persona menordni = vector[0];
            for(i=0; i<dl; i++){
                if(vector[i].getDNI() < menordni.getDNI()){
                    menordni = vector[i];
                    }
            }
            System.out.println("el documento mas chico es: " + menordni.toString());
        }
    System.out.println("La cantida de gente mayor a 65 es: " + cantedad);
    }
}
