package tema2;
public class work {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.setNombre("pepito");
        p1.setDNI(420290123);
        p1.setEdad(24);
        
        Persona p2 = new Persona("ana", 2341232, 23);
        System.out.println(p1);
        System.out.println(p2);
    }
}
