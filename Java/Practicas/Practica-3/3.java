package tema3;
import PaqueteLectura.Lector;
public class main {

    public static void main(String[] args) {
    estante Estante = new estante();
    int cant = 0;
    
    while(cant < 3){      
        System.out.println("ingrese un titulo");
        String titulo = Lector.leerString();
        
        System.out.println("ingrese informacion del autor");
        String nombre = Lector.leerString();
        String biografia = Lector.leerString();
        String origen = Lector.leerString();
        autor Autor = new autor(nombre, biografia, origen);
    
        System.out.println("ingrese la editorial");
        String editorial = Lector.leerString();
        
        System.out.println("ingrese el anio de edicion");
        int edicion = Lector.leerInt();
        
        System.out.println("ingrese el ISBN");
        String isbn = Lector.leerString();
        
        System.out.println("ingrese el precio");
        double precio = Lector.leerDouble();
        
        Libro libro = new Libro(titulo, editorial, edicion, Autor, isbn, precio);
        
        if(Estante.agregarlibro(libro)){
            System.out.println("libro agregado");
            cant++;
        }
        else{
            System.out.println("estante lleno");
        }
    }
        ////////////////////////////////////////////////////////////////////////////////////
        System.out.println("la cantida de libros son: " + Estante.cantidadlibros());
        ////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("ingrese un titulo para buscar");
        String buscar = Lector.leerString();
        Libro encontrado = Estante.buscarPorTitulo(buscar);
        if(encontrado != null){
                System.out.println("encontrado: " + encontrado);
        }
        else{
            System.out.println("no se encontro");
        }       
        ////////////////////////////////////////////////////////////////////////////////////
        
        Libro buscado = Estante.buscarPorTitulo("mujercitas");
        if(buscado != null){
            System.out.println("el auto de mujercitas es: " + buscado.getPrimerAutor().getnombre());
        }
        else{
            System.out.println("el libro mujercitas no se encontro");
        }
    }
}
