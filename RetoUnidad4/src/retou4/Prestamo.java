package retou4;
import java.time.LocalDate;

public class Prestamo {


		 private String idPrestamo;
		    private Libro libro;
		    private Usuario usuario;
		    private LocalDate fechaPrestamo;
		    private LocalDate fechaDevolucion;
		    private boolean devuelto; 

		
	public Prestamo(String idPrestamo, Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
	        this.idPrestamo = idPrestamo;
	        this.libro = libro;
	        this.usuario = usuario;
	        this.fechaPrestamo = fechaPrestamo;
	        this.fechaDevolucion = fechaDevolucion;
	        this.devuelto = false;
	    }
	

	public String getIdPrestamo() {
	        return idPrestamo;
	    }

	    public Libro getLibro() {
	        return libro;
	    }

	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public LocalDate getFechaPrestamo() {
	        return fechaPrestamo;
	    }

	    public LocalDate getFechaDevolucion() {
	        return fechaDevolucion;
	    }
	    public void marcarDevolucion() {
	        if (!devuelto) {
	            this.fechaDevolucion = LocalDate.now();
	            this.devuelto = true;
	            System.out.println("El libro ha sido devuelto.");
	        } else {
	            System.out.println("Este libro ya fue devuelto.");
	        }
	    }


	}
