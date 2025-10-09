package tema5.ej4;
public class Main {
    public static void main(String[] args) {
        Director d = new Director("alfonsin", 32189312, 32 , 2);
       
        Coristas c1 = new Coristas("juansito", 1232423, 32, 2);
        Coristas c2 = new Coristas("mati", 1234123, 22, 1);
        Coristas c3 = new Coristas("Cami", 333, 30, 7);
        Coristas c4 = new Coristas("Dani", 444, 35, 2);
        
    System.out.println("=== Coro Semicircular |capacidad de 3 ==="); 
    CoroSemi semi = new CoroSemi("los papagayos", d, 3);
    semi.agregarCorista(c1);
    semi.agregarCorista(c4);
    semi.agregarCorista(c2);
    
    System.out.println("el coro esta lleno? " + semi.estalleno());
    System.out.println(semi.toString());
    
    System.out.println("\n ===Coro por Hileras | capacidad 2x2 ===");
    Corohileras hile = new Corohileras("agarrate", d, 2, 2);
    hile.agregarCorista(c1);
    hile.agregarCorista(c4);
    hile.agregarCorista(c2);
    
    System.out.println("el coro esta lleno? " + hile.estalleno());
    }   
}
