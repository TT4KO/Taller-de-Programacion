package tema3;

public class triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private String colorRelleno;
    private String colorLinea;

    // Constructor con parámetros
    public triangulo(double unLadoA, double unLadoB, double unLadoC, String unColorRelleno, String unColorLinea){
        ladoA = unLadoA;
        ladoB = unLadoB;
        ladoC = unLadoC;
        colorRelleno = unColorRelleno;
        colorLinea = unColorLinea;
    }
    
    // Constructor vacío
    public triangulo(){
        
    }

    // Métodos GET
    public double getLadoA(){
        return ladoA;
    }
    public double getLadoB(){
        return ladoB;
    }
    public double getLadoC(){
        return ladoC;
    }
    public String getColorRelleno(){
        return colorRelleno;
    }
    public String getColorLinea(){
        return colorLinea;
    }

    // Métodos SET
    public void setLadoA(double unLadoA){
        ladoA = unLadoA;
    }
    public void setLadoB(double unLadoB){
        ladoB = unLadoB;
    }
    public void setLadoC(double unLadoC){
        ladoC = unLadoC;
    }
    public void setColorRelleno(String unColorRelleno){
        colorRelleno = unColorRelleno;
    }
    public void setColorLinea(String unColorLinea){
        colorLinea = unColorLinea;
    }
    
    public double calcularperimetro(){
        return ladoA + ladoB + ladoC;
    }
    
    public double calcularArea() {
    double s = (ladoA + ladoB + ladoC) / 2.0;
    return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }
}
