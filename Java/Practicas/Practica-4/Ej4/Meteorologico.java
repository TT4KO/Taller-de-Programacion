package tema4.ej4;

public abstract class Meteorologico {
    private Estacion estacion;
    private int anioinicio;
    private int N;
    private double valorinicial = 999.0;
    protected double[][]temperaturas;

   public Meteorologico(Estacion estacion, int anioinicio, int N){
       this.estacion = estacion;
       this.anioinicio = anioinicio;
       this.N = N;
       this.temperaturas = new double[N][12];
       for (int i=0; i<N; i++){
           for(int j=0; j<12; j++){
               temperaturas[i][j]= valorinicial;
           }
        }
   }

    public Estacion getEstacion() {
        return estacion;
    }

    public int getAnioinicio() {
        return anioinicio;
    }

    public int getN() {
        return N;
    }


    public void registrartemperatura(int mes, int anio, double temperatura){
        int indiceanio = anio - anioinicio;
        int indicemes = mes - 1;
        temperaturas[indiceanio][indicemes] = temperatura;
    }
    
    public abstract double[] calcularPromedioHistorico();
}
