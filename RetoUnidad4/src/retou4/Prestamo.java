package retou4;

public class Prestamo {
	static int cont_ids = 1;
	int id; //Identificador del préstamo.
	Libro libro;
	Usuario usuario;
	String fechaInicio;
	String fechaFinal; //Para comprobar si el préstamo ha finalizado, se comprobará si el valor de fechaFinal equivale a "".
	
/*
		 private String idPrestamo;
		    private Libro libro;
		    private Usuario usuario;
		    private LocalDate fechaPrestamo;
		    private LocalDate fechaDevolucion;
		    private boolean devuelto; 
*/
		
	public Prestamo(int id, Libro libro, Usuario usuario, String fechaInicio) {
	        this.id = id;
	        this.libro = libro;
	        this.usuario = usuario;
	        this.fechaInicio = fechaInicio;
	}
	
	    public void marcarDevolucion() {
	        /*if (!devuelto) {
	            this.fechaDevolucion = LocalDate.now();
	            this.devuelto = true;
	            System.out.println("El libro ha sido devuelto.");
	        } else {
	            System.out.println("Este libro ya fue devuelto.");
	        }*/
	    }
}