package retou4;

public class Libro {
    static int cont_ids = 1;
	int id;
    String titulo;
    String autor;
    int añoPublicacion;
    //String[] reservas; 
    int cantidad;
    static Libro[] libros = new Libro[32]; 
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
    
    public static void registrarLibro(String titulo, String autor, int añoPublicacion, int cantidad) {
        int cantidadLibros = Libro.contarLibros();
    	if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = new Libro(cont_ids, titulo, autor, añoPublicacion, cantidad);
            cont_ids++;
        } else {
            System.out.println("No hay espacio para más libros.");
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
            if (libros[i].titulo.toLowerCase().equals(titulo.toLowerCase())) {
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
}
