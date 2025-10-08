package tema5;
public class Main {
    public static void main(String[] args) {
        Proyectos p = new Proyectos("inteligencia artifial", 101, "Dra.Garcia");
        
        Investigadores i1 = new Investigadores("juansito", 2, "Vision artificial");
        
        Subsidio s1 = new Subsidio(10000, "Compra de equipos");
        
        i1.agregarsubsidio(s1);
        p.agregarinvestigador(i1);
        
        System.out.println(p.toString());
    }   
}
