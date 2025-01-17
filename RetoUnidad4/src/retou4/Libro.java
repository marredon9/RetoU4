package retou4;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String[] reservas; 
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
        this.reservas = new String[cantidad];  
        
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
    
    public String[] getReservas() {
        return reservas;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año: " + añoPublicacion + ", Cantidad: " + cantidad + ", Reservas: " + getCantidadReservas();
    }

    public int getCantidadReservas() {
        int count = 0;
        for (String reserva : reservas) {
            if (reserva != null) {
                count++;
            }
        }
        return count;
    }
}
