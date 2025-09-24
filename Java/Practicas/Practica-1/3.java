package tema1;
//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
public class NewMain {
    public static void main(String[] args) {
	    //Paso 2. iniciar el generador aleatorio     
           GeneradorAleatorio.iniciar();	 
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] tabla = new int [5][5];
        int i, j;
        for (i=0; i<5; i++){
            for (j=0; j<5; j++){
                tabla[i][j] = GeneradorAleatorio.generarInt(12);
            }
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        for (i=0; i<5; i++){
            for (j=0; j<5; j++){
            System.out.println(tabla[i][j] + "/t");
            System.out.println(); //
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
    
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.

        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".

        }
    }
}
