import PaqueteLectura.GeneradorAleatorio;

public class NewMain {
    public static void main(String[] args) {
        int DF = 12; // vector con posiciones 0..11
        int[] tabla2 = new int[DF];

        // Cargar el vector con la tabla del 2
        for (int i = 0; i < DF; i++) {
            tabla2[i] = 2 * i;
        }

        // Inicializar el generador aleatorio
        GeneradorAleatorio.iniciar();

        int numero;
        do {
            numero = GeneradorAleatorio.generarInt(12); // genera 0..11
            System.out.println("Número generado: " + numero);
            System.out.println(numero + " x 2 = " + tabla2[numero]);
        } while (numero != 11);

        System.out.println("¡Se generó el 11, fin del programa!");
    }
}
