package tema3;

public class Hotel {
    private Habitacion[] habitaciones;

    public Hotel(int n){
        habitaciones = new Habitacion[n];
        for (int i=0; i<n; i++){
            habitaciones[i] = new Habitacion();
        }
    }

    public Habitacion[] gethabitaciones(){
        return habitaciones;
    }
    
    public boolean reservarHabitacion(int numero, Persona cliente) {
        if (numero >= 0 && numero < habitaciones.length) {
            Habitacion hab = habitaciones[numero];
            if (!hab.isocupada()) {
                hab.setcliente(cliente);
                return true;
            }
        }
        return false;
    }

    // Método para mostrar estado del hotel
    public void mostrarEstado() {
        for (int i = 0; i < habitaciones.length; i++) {
            Habitacion hab = habitaciones[i];
            System.out.println("Habitación " + (i+1) + 
                " | Costo: $" + hab.getcostoponoche()+
                " | Ocupada: " + hab.isocupada()+
                (hab.isocupada()? " | Cliente: " + hab.getcliente().getNombre() : ""));
        }
    }
}
