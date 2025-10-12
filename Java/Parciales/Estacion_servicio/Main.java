package Estacion_Servicio;
public class Main {
    public static void main(String[] args) {
        Estacion e = new Estacion("puente roma");
        
        Surtidor s1 = new Surtidor("infinia", 200.0, 5);
        Surtidor s2 = new Surtidor("super", 150.0, 5);
        Surtidor s3 = new Surtidor("diesel", 10.0, 3);
        
        e.agregar(s1);
        e.agregar(s2);
        e.agregar(s3);
        
        Venta v1 = new Venta(429103, 10, 20000, "efectivo");
        Venta v2 = new Venta(312321, 5, 5000, "MP");
    
        s1.agregarventa(v2);
        s1.agregarventa(v1);
        
        Venta v3 = new Venta(11223344, 10, 9000.0, "Efectivo");
        s2.agregarventa(v3);
        
        System.out.println("el surtidor que mas recaudo es: " + e.recaudacionmax());
        System.out.println("============");
        System.out.println(e.toString());
    }
    
}
