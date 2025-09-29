package tema2;
import PaqueteLectura.GeneradorAleatorio;
public class work {
    public static void main(String[] args) {
        int turnos = 8, dias = 5, edad, dni;
        Persona [][] vector = new Persona [dias][turnos];
        int inscriptos = 0;
        String nombre;
          
        GeneradorAleatorio.iniciar();
        
        System.out.println("ingrese su nombre: " );
        nombre = GeneradorAleatorio.generarString(3);
        while(!nombre.equals("ZZZ") && inscriptos < dias * turnos){
        
            System.out.println("ingrese su dni: " );
            dni = GeneradorAleatorio.generarInt(4123123);
            System.out.println("ingrese su edad: " );
            edad = GeneradorAleatorio.generarInt(60);
        
            int dia = inscriptos / turnos;   // 0..4
            int turno = inscriptos % turnos;
            
            vector[dia][turno] = new Persona(nombre, dni, edad);
            inscriptos++;
            System.out.println("ingrese su nombre: " );
             nombre = GeneradorAleatorio.generarString(3);
        }   
    System.out.println("listado de inscriptos");
        for(int i=0; i<dias; i++){
            for(int j=0; j<turnos; j++){
                if(vector[i][j] != null){
                    System.out.println("Dia " + (i+1) + " Turno " + (j+1) + " : " + vector[i][j].toString()); 
                } 
            }
        }
    }
}
