//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.Lector;
public class NewMain {
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        int df = 5;
        //Paso 3: Crear el vector para 15 double 
        double[] tabla = new double[df];
        //Paso 4: Declarar indice y variables auxiliares a usar
        double total = 0;
        int cantidad = 0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for(int i = 0; i < df; i++){
            System.out.println("ingrese una altura " + (i+1) + ": ");
            tabla[i] = Lector.leerDouble();
            total += tabla[i];
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        total = total / df;
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        for(int i = 0; i <df; i++){
            if(tabla[i] > total){
                cantidad++;
            }
        }
        //Paso 9: Informar la cantidad.
        System.out.println("el total de las alturas son: " + total);
        System.out.println("la cantidad que superan al promedio son: " + cantidad);
    }
}
