package tema4.Ej1;
public abstract class Figuras {
    private String color;
    private String linea;

    public Figuras(String uncolor, String unlinea) {
        setColor(uncolor);
        setLinea(unlinea);
    }
    
    public String toString(){
        String aux = "area: " + this.calculararea() +
                    + this.calcularperimetro() +
                     " Color: " + getColor() +
                     " Linea: " + getLinea();
                return aux;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getLinea() {
        return linea;
    }
   

    public void setLinea(String linea) {
        this.linea = linea;
    }
      
    public abstract double calculararea();
    public abstract double calcularperimetro();
    
}
