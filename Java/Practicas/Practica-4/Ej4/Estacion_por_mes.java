package tema4.ej4;
public class Estacionpormes extends Meteorologico{
    

    public Estacionpormes(Estacion estacion, int anioinicio, int N){
        super(estacion, anioinicio, N);
    }
    
    public double[] calcularPromedioHistorico(){
        double[] promedio = new double[12];
        for(int mes= 0; mes<12; mes++){
            double suma = 0;
            int contador = 0;
            
            for(int anio = 0; anio < getN(); anio++){
                suma+= temperaturas[anio][mes];
                contador++;
            }
        if(contador > 0){
            promedio[mes] = suma / contador;
        }else{
            promedio[mes] = 0;
        }          
    }
    return promedio;
}
}
