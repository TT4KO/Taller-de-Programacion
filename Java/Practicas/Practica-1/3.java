package tema1;
//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class NewMain {
    public static void main(String[] args) {

		
	    //Paso 2. iniciar el generador aleatorio     
           GeneradorAleatorio.iniciar();	

		
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] tabla = new int [3][3];
        int i, j;
        for (i=0; i<3; i++){
            for (j=0; j<3; j++){
                tabla[i][j] = GeneradorAleatorio.generarInt(12);
            }
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        for (i=0; i<3; i++){
            for (j=0; j<3; j++){                
            System.out.print(tabla[i][j] + "-");
        }
        }

		
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        System.out.println();
        int suma = 0;
        for (j=0; j<3; j++){
            suma += tabla[1][j];          
            }
        System.out.println("la suma de los elementos son: " + suma);

		
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int df = 3;       
        int[] vector = new int[df];
        for (j=0; j<3; j++){
            int total = 0;
            for (i=0; i<3; i++){
            total += tabla[i][j];
           } 
           vector[j]=+total;
        }
        System.out.print("la suma de cada columna es: " );
        for(j=0; j<df; j++){
            System.out.print(vector[j] + "-");
        }

		
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        int buscado = 0;
        System.out.println();
        System.out.println("ingrese un numero para buscar: " );
        buscado = Lector.leerInt();
        boolean encontrado = false;
        int fila = -1, columna = -1;
        for(i = 0; i < 3 && !encontrado; i++){
            for(j = 0; j < 3 && !encontrado; j++){
                if(tabla[i][j] == buscado){
                    encontrado = true;
                    fila = i;
                    columna = j;
                }
            }
        }  
    if(encontrado){
        System.out.println("se encontro el valor " + buscado + " en la fila " + fila + " en la columna" + columna);
    }
        else{
         System.out.println("no se encontro");
        }
    }
}
