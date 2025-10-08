package tema5.ej2;
public class Main {
    public static void main(String[] args) {
        Estacionamientob e = new Estacionamientob("villa carlitos", "dig 64");       
    Auto a1 = new Auto("pepito", "ABC123ADD");
    Auto a2 = new Auto("pablito", "FFF123FWA");
    
    e.registrarauto(a1, 1, 1);
    e.registrarauto(a2, 2, 2);   
    
    System.out.println(e.toString());
    
    System.out.println(e.busccarpatente("ABC123ADD"));
    
    System.out.println(e.contarautos(2));
    }    
}
