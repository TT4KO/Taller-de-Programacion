package Parcial;
public class Main {
    public static void main(String[] args) {
       Nadadores n1 = new Nadadores("juansito", 12000000, 2000000, 5, "pedrito", 500000);
        n1.agregar(new Chicos("Martin", 3213232, true));
        n1.agregar(new Chicos("juan", 233213, false));
        
        Exploradores e1 = new Exploradores("pacheco", 400.0, 200.0, 3, 300.0);
        e1.agregar(new Chicos("carla", 321312, false));
        e1.agregar(new Chicos("diosito", 44, true));
        
       
        
        System.out.println("\n===========================");
        System.out.println(n1.toString());
        
        System.out.println("\n===========================");
        System.out.println(e1.toString());
        
        System.out.println("\n===========================");
        System.out.println("el grupo de nadadores es rentable? " + (n1.rentable() ? "**si**" : "**no**"));
        System.out.println("el grupo de exploradores es rentable? " + e1.rentable());
    }      
}
