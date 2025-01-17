package retou4;

public class Reserva {
	static int numero_reserva = 1; //Usada para dar un valor unico a cada id. Sumar 1 cuando se llame al constructor.
	static Reserva[] reservas = new Reserva[64];
	int id;
	Usuario usuario;
	Libro libro;
	String fecha;
	
	private Reserva(Usuario usuario, Libro libro, String fecha)
	{
		this.id = numero_reserva;
		this.libro = libro;
		this.fecha = fecha;
		this.usuario = usuario;
	}
	
	static void crearReserva(Usuario usuario, Libro libro, String fecha)
	{
		for (int i = 0; i < reservas.length; i++)
		{
			if (reservas[i] == null)
			{
				reservas[i] = new Reserva(usuario, libro, fecha);
				System.out.println("Se ha creado una reserva en con el ID " + numero_reserva);
				numero_reserva++;
				return;
			}
		}
		System.out.println("La lista de reservas está llena. No se ha podido registrar la reserva.");
	}
	
	static void liberarReserva(int id)
	{
		//buscar reserva
		int index = -1; //numero de indice en la lista de reservas
		for (int i = 0; i < reservas.length; i++)
		{
			if (reservas[i] == null)
			{
				break;
			}
			/*else if (reservas[i].id != id) //posiblemente el error de la reserva esté relacionado con la detección de datos de entrada del escáner.
			{
				System.out.println(reservas[i].id);
				System.out.println(id);
			}*/
			else if (reservas[i].id == id)
			{
				index = i;
				break;
			}
		}
		
		if (index == -1)
		{
			System.out.println("No se ha encontrado una reserva activa con el ID " + id);
			return;
		}
		
		for (int i = index; i < reservas.length; i++)
		{
			if (i == reservas.length - 1) //si es el último elemento del array
			{
				reservas[i] = null;
			}
			else
			{
				reservas[i] = reservas[i + 1];
			}
		}
		
		System.out.println("Se ha liberado la reserva " + id + ".");
		
	}
	
	static int contarReservas(Libro libro)
	{
		int cuentaReservas = 0;
		for (int i = 0; i < reservas.length; i++)
		{
			if (reservas[i] == null) break;
			if (reservas[i].libro.equals(libro))
			{
				cuentaReservas++;
			}
		}
		return cuentaReservas;
	}
	
	static void listarReservas()
	{
		for (int i = 0; i < reservas.length; i++)
		{
			if (reservas[i] == null) return;
			System.out.println(reservas[i].toString());
		}
	}
	
	@Override
	public String toString()
	{
		return "ID: " + this.id + " Título: " + this.libro.titulo + " Usuario: " + this.usuario.nombre + " Fecha: " + this.fecha;
	}
	
}
