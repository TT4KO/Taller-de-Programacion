package tema5;
public class Subsidio {
    private double montopedido;
    private String motivo;
    private boolean entregado;
    
    private Subsidio(double montopedido, String motivo, boolean entregado){
        this.montopedido = montopedido;
        this.motivo = motivo;
        this.entregado = false;
    }

    public double getMontopedido() {
        return montopedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setMontopedido(double montopedido) {
        this.montopedido = montopedido;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
    
    
}
