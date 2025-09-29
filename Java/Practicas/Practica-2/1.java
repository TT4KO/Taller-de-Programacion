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
----------------------------------
package tema2;
import PaqueteLectura.Lector;
public class work {
    public static void main(String[] args) {
        System.out.print("ingrese un nombre: " );
        String Nombre = Lector.leerString();
        
        System.out.print("ingrese el documento: " );
        int dni = Lector.leerInt();
        
        System.out.print("ingrese la edad: " );
        int edad = Lector.leerInt();
        
        Persona p = new Persona(Nombre, dni, edad);
        
        System.out.print((p.toString()));
    }
}
