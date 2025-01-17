package retou4;
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibro(new Libro("1", "El Quijote", "Cervantes"));
        biblioteca.agregarLibro(new Libro("2", "Cien años de soledad", "García Márquez"));
