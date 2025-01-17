package retou4;
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibro(new Libro("1", "El Quijote", "Cervantes"));
        biblioteca.agregarLibro(new Libro("2", "Cien años de soledad", "García Márquez"));

        biblioteca.agregarUsuario(new Usuario("U1", "Juan", "Estudiante"));
        biblioteca.agregarUsuario(new Usuario("U2", "María", "Profesor"));

        biblioteca.realizarPrestamo("P1", "1", "U1");
        biblioteca.realizarPrestamo("P2", "2", "U1");
