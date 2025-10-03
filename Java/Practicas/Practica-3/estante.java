package tema3;
public class estante {
    private Libro[] libros;
    private int diml;
    private final int dimf = 3;
    
    public estante(){
        libros = new Libro[dimf];
        diml = 0;
    }
    public boolean agregarlibro(Libro l){
        if(diml < dimf){
            libros[diml] = l;
            diml++;
            return true;
        } else{
            return false;
        }
    }
      
    public int cantidadlibros(){
        return diml;
    }
    public Libro getLibro(int i){
        if(i >=0 && i < diml){
            return libros[i];
        }
        else{
            return null;
        }
    }
    public Libro buscarPorTitulo(String titulo) {
        for (int i = 0; i < diml; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return libros[i];
            }
        }
        return null;
    }
}
