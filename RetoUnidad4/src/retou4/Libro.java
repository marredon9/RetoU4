package retou4;

public class Libro {
    int id;
    String titulo;
    String autor;
    int añoPublicacion;
    //String[] reservas; 
    int cantidad;
    static Libro[] libros = new Libro[10]; 
    //static int cantidadLibros = 0; 

    // Constructor
    public Libro(int id, String titulo, String autor, int añoPublicacion, int cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.cantidad = cantidad;
        //this.reservas = new String[cantidad];  
        
    }
    
    static int contarLibros()
    {
    	int cuenta = 0;
    	for (cuenta = 0; cuenta < libros.length; cuenta++)
    	{
    		if (libros[cuenta] == null) break;
    	}
    	return cuenta;
    }
    
    int contarReservas()
    {
    	return Reserva.contarReservas(this);
    }
    
    boolean equals(Libro libro)
    {
    	return (this.id == libro.id);
    }
    
    @Override
    public String toString() {
        return "ID: " + this.id + ", Título: " + this.titulo + ", Autor: " + this.autor + ", Año: " + this.añoPublicacion + ", Cantidad: " + cantidad + ", Reservas: " + this.contarReservas();
    }
    
    public static boolean registrarLibro(int id, String titulo, String autor, int añoPublicacion, int cantidad) {
        int cantidadLibros = Libro.contarLibros();
    	if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = new Libro(id, titulo, autor, añoPublicacion, cantidad);
            return true;
        } else {
            System.out.println("No hay espacio para más libros.");
            return false;
        }
    }
    
    public static Libro consultarLibroPorId(int id) {
        int cantidadLibros = Libro.contarLibros();
    	for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].id == id) {
                return libros[i];
            }
        }
        return null; 
    }

    public static Libro consultarLibroPorTitulo(String titulo) {
    	int cantidadLibros = Libro.contarLibros();
    	for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].titulo.toLowerCase().contains(titulo.toLowerCase())) {
                return libros[i];
            }
        }
        return null; 
    }
    
    public static void mostrarLibros() {
    	int cantidadLibros = Libro.contarLibros();
    	if (cantidadLibros == 0) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < cantidadLibros; i++) {
                System.out.println(libros[i]);
            }
        }
    }
    
    public boolean añadirReserva(String nombreReserva) {
        for (int i = 0; i < cantidad; i++) {
            if (reservas[i] == null) {
                reservas[i] = nombreReserva;
                System.out.println("Reserva añadida para el libro: " + titulo);
                return true;
            }
        }
        System.out.println("No hay copias disponibles para reservar.");
        return false;
    }
    
    public boolean eliminarReserva(String nombreReserva) {
        for (int i = 0; i < cantidad; i++) {
            if (reservas[i] != null && reservas[i].equalsIgnoreCase(nombreReserva)) {
                reservas[i] = null;
                System.out.println("Reserva eliminada para el libro: " + titulo);
                return true;
            }
        }
        System.out.println("No se encontró la reserva para el libro: " + titulo);
        return false;
    }
}
