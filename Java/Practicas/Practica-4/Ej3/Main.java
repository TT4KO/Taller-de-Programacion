package tema4.ej3;
public class Main {

    public static void main(String[] args) {
        Persona p = new Persona("alfonsin", 1238932, 40);
        Trabajador t = new Trabajador("alfonsin", 1238932, 40, "filosofo");
        
        System.out.println(p);
        System.out.println(t);
    }
}
