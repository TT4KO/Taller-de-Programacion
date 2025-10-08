package tema5.ej2;
class Estacionamientob {
    private String nombre;
    private String direccion;
    private String horaapertura;
    private String horacierre;
    private Auto[][] autos;
    private int pisos;
    private int plazas;
    
    public Estacionamientob(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaapertura = "8:00";
        this.horacierre = "21:00";
        this.pisos = 5;
        this.plazas = 10;
        this.autos = new Auto[pisos][plazas];
    }
    
    public Estacionamientob(String nombre, String direccion, String horaapertura, String horacierre, int pisos, int plazas){
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaapertura = horaapertura;
        this.horacierre = horacierre;
        this.pisos = pisos;
        this.plazas = plazas;
        this.autos = new Auto[pisos][plazas];
    }
    public String getNombre() {return nombre; }
    public String getDireccion() {return direccion;    }
    public String getHoraapertura() {return horaapertura;  }
    public String getHoracierre() { return horacierre;    }
    public int getPisos() {return pisos;    }
    public int getPlazas() {return plazas;    }
    
    
    public void registrarauto(Auto a, int piso, int plaza){
        if(piso >= 1 && piso <= pisos && plaza >=1 && plaza <= plazas){
        if(autos[piso - 1][plaza - 1] == null){
            autos[piso - 1][plaza - 1] = a;
        }else{
            System.out.println("la plaza ya esta ocupada");
        }            
        }
    }
    
     public String busccarpatente(String patente){
        for(int i= 0; i<pisos; i++){
            for(int j=0; j<plazas; j++){
                if(autos[i][j].getPatente().equalsIgnoreCase(patente)){
                    return "El auto con patente " + patente + " en el piso " +
                            (i+1) + " en la plaza " + (j+1) + " con nombre "
                            + autos[i][j].getDueno();
                }                
            }
        }
        return "Auto inexistente";
    }
    
    public String toString(){
        String aux = "Estacionamiento: " + nombre + " | Direcion: " + direccion +
                " | apertura: " + horaapertura + " | cierre: " + horacierre + "\n\n";
            for(int i=0; i<pisos; i++){
                aux += "Piso: " + (i+1) + "\n";
                for(int j=0; j<plazas; j++){
                    if(autos[i][j] != null){
                         aux += " Plaza: " + (j+1) + ": " + autos[i][j].toString() + "\n";
                    }                    
                    else{
                        aux += "Plaza: " + (j+1) + " | Vacia\n";
                    }
                }
            }
        return aux;
    }
    
    public int contarautos(int plaza){
        int cant = 0;
        for(int i=0; i<pisos; i++){            
                if(autos[i][plaza - 1] != null){
                    cant++;
                }
            }
        return cant;
    }
}
