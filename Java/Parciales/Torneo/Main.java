package Torneo;
public class Main {
    public static void main(String[] args) {
        Amateur a = new Amateur("ches novato", "novado.com");
        
        a.setCant(1000);
        a.setCantclicks(5000);
        a.setCanttorneos(10);
        
        System.out.println(a.toString());
        
        Profesionales p = new Profesionales("vegadura", "www.quedura", 10);
        p.setCant(2500);
        
        Torneo t1 = new Torneo("wawa", 1232, 100000.0, 200000.0);
        Torneo t2 = new Torneo("g1", 1232, 150000.0, 300000.0);
        
        p.agregar(t1);
        p.agregar(t2);
        System.out.println(p.toString());
    }
    
}
