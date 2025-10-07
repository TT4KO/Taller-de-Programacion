package tema4.ej4;

public class Estacionporanio extends Meteorologico{
    
    public Estacionporanio(Estacion estacion, int anioinicio, int N){
        super(estacion, anioinicio, N);
    }
    
    public double[] calcularPromedioHistorico(){
        double[] promedio = new double[ getN() ];
        for(int i=0; i<getN(); i++){
            double suma = 0;
            int contador = 0;
            for(int j=0; j < 12 ; j++){
                suma += temperaturas[i][j];
                contador++;
            }
            if(contador > 0){
                promedio[i]=suma/contador;
            }else{
                promedio[i]=0;
            }
        }
    return promedio;
    }
}
