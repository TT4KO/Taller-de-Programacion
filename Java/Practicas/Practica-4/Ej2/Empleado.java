package tema4.ej2;
    public abstract class Empleado {
        private String nombre;
        private double sueldo;
        private int antiguedad;
    
        public Empleado(String nombre, double sueldo, int antiguedad){
            setNombre(nombre);
            setSueldo(sueldo);
            setAntiguedad(antiguedad);
        }

     public String toString(){
        String aux = "nombre del jugador: " + getNombre() +
                     " | sueldo a cobrar: " + this.calcularsueldoacobrar()+
                     " | efectividad: " + this.calcularefectividad();               
        return aux;
    }
        
    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
        
    public abstract double calcularefectividad();
    public abstract double calcularsueldoacobrar();
}
