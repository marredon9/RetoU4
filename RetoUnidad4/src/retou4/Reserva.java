package retou4;

public class Reserva {
	static int numero_reserva; //Usada para dar un valor unico a cada id. Sumar 1 cuando se llame al constructor.
	int id;
	Usuario usuario;
	Libro libro;
	String fecha;
	
	Reserva(Usuario usuario, Libro libro, String fecha)
	{
		this.id = numero_reserva;
		numero_reserva++;
		this.libro = libro;
		this.fecha = fecha;
	}
}
