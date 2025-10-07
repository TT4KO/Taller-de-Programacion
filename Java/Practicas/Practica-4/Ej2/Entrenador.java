package tema4.ej2;

public class Entrenador extends Empleado{
    private int victorias;
  
    public Entrenador(int victorias, String nombre, double sueldo, int antiguedad){
        super(nombre, sueldo, antiguedad);
        setVictorias(victorias);
    }

    public int getVictorias() {
        return victorias;
    }
    

    
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
    
    public double calcularefectividad(){
        int aux = victorias / getAntiguedad();
        return aux;
    }
    
    public double calcularsueldoacobrar(){
        double salario = getSueldo();
        salario += getSueldo() * 0.10 * getAntiguedad();
        if(victorias > 0 && victorias < 4){
            salario+= 5000;
        }
        if(victorias >= 5 && victorias <= 10){
            salario += 30000;
        }
        if(victorias > 10){
            salario += 50000;
        }
        return salario;
    }
}
