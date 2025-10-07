package tema4.ej4;
public class Main {
    public static void main(String[] args) {
       Estacion e = new Estacion ("mar del plata", -30.4, -49.3);
       
       Estacionporanio poranios = new Estacionporanio(e, 2020, 3);
       Estacionpormes pormes = new Estacionpormes(e, 2020, 3);
       
        poranios.registrartemperatura(1, 2020, 22.5);
        poranios.registrartemperatura(2, 2020, 25.0);
        poranios.registrartemperatura(3, 2020, 20.0);

        poranios.registrartemperatura(1, 2021, 24.0);
        poranios.registrartemperatura(2, 2021, 26.5);
        poranios.registrartemperatura(3, 2021, 23.0);

        // Mostrar promedios por año
        System.out.println(poranios);
        double[] promedioAnio = poranios.calcularPromedioHistorico();
        for (int i = 0; i < promedioAnio.length; i++) {
            System.out.println("Año " + (2020 + i) + ": " + promedioAnio[i]);
        }

        // Mostrar promedios por mes
        System.out.println("\n" + pormes);
        double[] promedioMes = pormes.calcularPromedioHistorico();
        for (int i = 0; i < promedioMes.length; i++) {
            System.out.println("Mes " + (i + 1) + ": " + promedioMes[i]);
        }
    }
}
