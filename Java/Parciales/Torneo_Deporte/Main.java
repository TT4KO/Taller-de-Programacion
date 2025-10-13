package FULVO;
public class Main {
    public static void main(String[] args) {
        Futbol f = new Futbol("hipico", 2023, 5000.0, 10000.0, 3);
        
        Equipos e1 = new Equipos("los tusi", "la plata", "tincho");
        Equipos e2 = new Equipos("unlp", "unlpdneah", "kobo");
        
        f.agregar(e2);
        f.agregar(e1);
        
        Tenis t = new Tenis("predio norte", 2023, 2000.0, 4000.0, 2, "sobre esta");
        
        System.out.println(f.toString());
        System.out.println(t.toString());
        
    }
    
}
