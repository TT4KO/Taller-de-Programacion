package tema1;
import PaqueteLectura.Lector;
public class NewMain{
    public static void main(String[] args){
        int dfpiso = 8, dfofi = 4;
        int i, j,  piso, oficina;
        int [][] tabla = new int [dfpiso][dfofi];
         
        oficina = Lector.leerInt();
                System.out.println("ingrese un numero de piso");
                piso = Lector.leerInt();
                while(piso != 9){
                    System.out.println("ingrese un numero de oficina");
                    oficina = Lector.leerInt();
                    
                    if(piso >= 1 && piso <= 8 && oficina >= 1 && oficina <= 4){
                        tabla[piso - 1][oficina - 1]++;
                    }                  
                System.out.println("ingrese un numero de piso");
                piso = Lector.leerInt();
                }
        System.out.println("cantidad de personas por oficina");
        for(i=0; i < dfpiso; i++){
            for(j=0; j<dfofi; j++){
                 System.out.println("piso " + (i+1) + " oficina " + (j+1) + tabla[i][j] + " personas");
            }
        }
    }
}
