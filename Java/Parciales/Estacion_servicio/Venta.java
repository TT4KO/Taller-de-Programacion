package Estacion_Servicio;
public class Venta {
    private int dni;
    private int cantlitros;
    private double monto;
    private String mediopago;
    
    public Venta(int dni, int cantlitros, double monto, String mediopago){
        this.dni = dni;
        this.cantlitros = cantlitros;
        this.monto = monto;
        this.mediopago = mediopago;
    }

    public int getDni() {
        return dni;
    }
    public int getCantlitros() {
        return cantlitros;
    }
    public double getMonto() {
        return monto;
    }
    public String getMediopago() {
        return mediopago;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setCantlitros(int cantlitros) {
        this.cantlitros = cantlitros;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void setMediopago(String mediopago) {
        this.mediopago = mediopago;
    }
    
   public String toString(){
       return " Dni: " + dni + " Cantidad litros: " + cantlitros;
   }
    
}
