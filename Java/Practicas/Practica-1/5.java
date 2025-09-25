package tema1;
import PaqueteLectura.Lector;

public class NewMain{
    public static void main (String[] args){
        int cliente = 5, aspectos = 4; 
        String[] nombres =  {"atencion", "calidad", "precio", "ambiente"};
        int[][] tabla = new int[cliente][aspectos];
        int i, j;
       
        for(i=0; i<cliente; i++){
            System.out.println("el cliente " + (i+1) + " califico con un: " );
            for(j=0; j<aspectos; j++){                                         
               System.out.print("nota de " + nombres[j] + ": ");
               tabla[i][j] = Lector.leerInt();
            }
        }
        
        
        //imprimo los resultados
        System.out.println("las notas son: " );
        for(i=0; i<cliente; i++){
            System.out.println("cliente " + (i+1));
            for(j=0; j<aspectos; j++){
                System.out.println(nombres[j] + ": " + tabla[i][j]);
            }
            System.out.println();
        }
        
        
        //calcular promedio
        System.out.println("promedio: " );      
        for(j=0; j<aspectos; j++){
            int suma = 0;   
            for(i=0; i<cliente; i++){
                suma += tabla[i][j];
            }
            double promedio = (double)suma/cliente;
            System.out.println(nombres[j] + ": " + promedio);
        }           
    }   
}
