package Supermercado;
public class Producto {
    private int codigo;
    private String nombreproducto;
    private String marca;
    private int cant;
    private double precio;
    
    public Producto(int codigo, String nombreproducto, String marca, int cant, double precio){
        this.codigo = codigo;
        this.nombreproducto = nombreproducto;
        this.marca = marca;
        this.cant = cant;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public String getMarca() {
        return marca;
    }

    public int getCant() {
        return cant;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int mayorcant(){
        int total = cant;
        return total;
    }
    
    public void mostrarproducto(){
        System.out.println(codigo + " - " + nombreproducto + " - " + marca + " - " + cant + " - " + precio);
    }
}
