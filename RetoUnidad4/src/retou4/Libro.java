package retou4;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private int cantidad;
    private static Libro[] libros = new Libro[10]; 
    private static int cantidadLibros = 0; 

    // Constructor
    public Libro(int id, String titulo, String autor, int añoPublicacion, int cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public int getCantidad() {
        return cantidad;
    }
}
