package retou4;

public class Reserva {
	static int numero_reserva; //Usada para dar un valor unico a cada id. Sumar 1 cuando se llame al constructor.
	static Reserva[] reservas = new Reserva[64];
	int id;
	Usuario usuario;
	Libro libro;
	String fecha;
	
	private Reserva(Usuario usuario, Libro libro, String fecha)
	{
		this.id = numero_reserva;
		numero_reserva++;
		this.libro = libro;
		this.fecha = fecha;
	}
	
	static void crearReserva(Usuario usuario, Libro libro, String fecha)
	{
		for (int i = 0; i < reservas.length; i++)
		{
			if (reservas[i] == null)
			{
				reservas[i] = new Reserva(usuario, libro, fecha);
				System.out.println("Se ha creado una reserva en la posición nº " + i);
				return;
			}
		}
		System.out.println("ERROR: La lista de reservas está llena. No se ha podido registrar la reserva.");
	}
}
