package retou4;

public class Prestamo {
	static int cont_ids = 1;
	int id; //Identificador del préstamo.
	Libro libro;
	Usuario usuario;
	String fechaInicio;
	String fechaFinal; //Para comprobar si el préstamo ha finalizado, se comprobará si el valor de fechaFinal equivale a "".
	static Prestamo[] prestamos = new Prestamo[64];
		
	public Prestamo(int id, Libro libro, Usuario usuario, String fechaInicio) {
	        this.id = id;
	        this.libro = libro;
	        this.usuario = usuario;
	        this.fechaInicio = fechaInicio;
	}
	
	void iniciarPrestamo(Libro libro, Usuario usuario, String fechaInicio)
	{
		if (prestamos[prestamos.length - 1] != null) return;
		for (int i = 0; i < prestamos.length; i++)
		{
			if (prestamos[i] == null)
			{
				prestamos[i] = new Prestamo(cont_ids, libro, usuario, fechaInicio);
				cont_ids++;
				break;
			}
		}
		libro.cantidad--;
	}
	
	void finalizarPrestmo(String fechaFinal) {
	    /*if (!devuelto) {
	        this.fechaDevolucion = LocalDate.now();
	        this.devuelto = true;
	        System.out.println("El libro ha sido devuelto.");
	    } else {
	        System.out.println("Este libro ya fue devuelto.");
	    }*/
		this.fechaFinal = fechaFinal;
		this.libro.cantidad++;
	}
	
	static void listarPrestamos()
	{
		if (prestamos[0] == null)
		{
			System.out.println("Actualmente no hay prestamos activos.");
			return;
		}
		for (int i = 0; i < prestamos.length; i++)
		{
			if (prestamos[i] == null) return;
			if (prestamos[i].fechaFinal.equals("")) continue; //si el prestamo ya ha finalizado, pasar al siguiente
			System.out.println(prestamos[i].toString());
		}
	}
	
	@Override
	public String toString()
	{
		return "ID: " + this.id + " Título del libro: " + this.libro.titulo + " Usuario: " + this.usuario.nombre + " Fecha de inicio: " + this.fechaInicio
				+ " Fecha de finalización: " + (this.fechaFinal.equals("") ? "Todavía vigente." : this.fechaFinal);
	}
}