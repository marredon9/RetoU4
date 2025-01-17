package retou4;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true)
		{	
			int opcion = getInt(sc, "Introduzca la operación a realizar:\n"
					+ "[0] Salir del programa.\n"
					+ "[1] Gestionar usuarios.\n"
					+ "[2] Gestionar libros.\n"
					+ "[3] Gestionar préstamos.\n"
					+ "[4] Gestionar reservas.\n");
			System.out.println();
			switch (opcion)
			{
			case 0:
				break;
			case 1:
				//GESTIÓN DE USUARIOS
				while (true)
				{
					int operacion = getInt(sc, "Introduzca la gestión de usuarios a realizar:\n"
							+ "[0] Volver.\n"
							+ "[1] Registrar nuevo usuario.\n"
							+ "[2] Listar usuarios existentes.\n");
					switch (operacion)
					{
					case 1:
						//REGISTRO DE USUARIO
						System.out.print("Introduce el nombre del nuevo usuario: ");
						String nombre = sc.next();
						boolean valid = true;
						String rol = "";
						while (true)
						{
							int rolElegido = getInt(sc, "Seleccione el rol del nuevo usuario:\n"
									+ "[1] Invitado\n"
									+ "[2] Estudiante\n"
									+ "[3] Profesor\n");
							switch (rolElegido)
							{
							case 1:
								rol = "Invitado";
								break;
							case 2:
								rol = "Estudiante";
								break;
							case 3:
								rol = "Profesor";
								break;
							default:
								valid = false;
								break;
							}
							if (valid) break;
						}
						int nuevo_id = Usuario.cont_ids;
						Usuario.registrarUsuario(nombre, rol);
						System.out.println("Se ha registrado el nuevo usuario con ID " + nuevo_id + ".");
						System.out.println();
						operacion = 0;
						break;
					case 2:
						//LISTADO DE USUARIOS
						Usuario.listarUsuario();
						System.out.println();
						operacion = 0;
						break;
					default:
						//ERROR
						System.out.println("La opción elegida no es válida.");
						break;
					}
					if (operacion == 0) break;
				}
				break;
			case 2:
				//GESTIÓN DE LIBROS
				while (true)
				{
					int operacion = getInt(sc, "Introduzca la gestión de libros a realizar:\n"
							+ "[0] Volver.\n"
							+ "[1] Registrar libro.\n"
							+ "[2] Buscar libro.\n"
							+ "[3] Ver libros disponibles.\n");
					switch (operacion)
					{
					case 0:
						break;
					case 1:
						//REGISTRAR LIBRO
						System.out.print("Introduce el título del libro a registrar: ");
						String titulo = sc.next();
						sc.nextLine(); //Cosas del escáner.
						System.out.print("Introduzca el autor del libro: ");
						String autor = sc.next();
						int año = obtenerAño(sc, "Introduzca el año de publicación del libro: ");
						int copias = -1;
						while (copias <= 0)
						{
							copias = getInt(sc, "Introduzca la cantidad de copias disponibles: ");
						}
						int nuevo_id = Libro.cont_ids;
						Libro.registrarLibro(titulo, autor, año, copias);
						System.out.println("Se ha registrado el nuevo libro con el ID " + nuevo_id);
						operacion = 0;
						break;
					case 2:
						//BUSCAR LIBRO
						while (true)
						{
							int busqueda = getInt(sc, "Introduzca el tipo de búsqueda a realizar: "
									+ "[0] Volver.\n"
									+ "[1] Búsqueda por ID.\n"
									+ "[2] Búsqueda por título.\n");
							int id_busqueda;
							String titulo_busqueda;
							Libro resultado;
							switch (busqueda)
							{
							case 0:
								break;
							case 1:
								//BÚSQUEDA POR ID
								id_busqueda = getInt(sc, "Introduzca el ID a buscar: ");
								resultado = Libro.consultarLibroPorId(id_busqueda);
								if (resultado == null)
								{
									System.out.println("No hay resultados para la búsqueda.");
								}
								else
								{
									System.out.println("El resultado de la búsqueda es el siguiente:");
									System.out.println(resultado.toString());
								}
								busqueda = 0;
								break;
							case 2:
								//BÚSQUEDA POR TÍTULO
								titulo_busqueda = sc.next();
								resultado = Libro.consultarLibroPorTitulo(titulo_busqueda);
								if (resultado == null)
								{
									System.out.println("No hay resultados para la búsqueda.");
								}
								else
								{
									System.out.println("El resultado de la búsqueda es el siguiente:");
									System.out.println(resultado.toString());
								}
								busqueda = 0;
								break;
							default:
								System.out.println("La opción elegida no es válida.");
								break;
							}
							if (busqueda == 0) break;
						}
						break;
					case 3:
						//LISTAR LIBROS
						System.out.println("Libros disponibles:");
						Libro.mostrarLibros();
						break;
					default:
						//ERROR
						System.out.println("La opción elegida no es válida.");
						break;
					}
					if (operacion == 0) break;
				}
				break;
			case 3:
				//GESTIÓN DE PRÉSTAMOS
				break;
			case 4:
				//GESTIÓN DE RESERVAS
				break;
			default:
				System.out.println("Error: La opción elegida no es válida.");
				break;
			}
			if (opcion == 0) break;
		}
		System.out.println("Se ha salido del programa. Hasta pronto!");
    }

    /*private static void registrarLibro(Scanner scanner) {
        int id = Libro.obtenerNumero(scanner, "Ingrese el ID del libro: ");
        String titulo = Libro.obtenerTexto(scanner, "Ingrese el título del libro: ");
        String autor = Libro.obtenerTexto(scanner, "Ingrese el autor del libro: ");
        
        int año = Libro.obtenerAño(scanner, "Ingrese el año de publicación: ");
        
        int cantidad = Libro.obtenerNumero(scanner, "Ingrese la cantidad de copias disponibles: ");

        if (Libro.registrarLibro(id, titulo, autor, año, cantidad)) {
            System.out.println("Libro registrado con éxito.");
        }
    }


    private static void consultarLibroPorId(Scanner scanner) {
        int id = Libro.obtenerNumero(scanner, "Ingrese el ID del libro a consultar: ");
        Libro libro = Libro.consultarLibroPorId(id);
        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void consultarLibroPorTitulo(Scanner scanner) {
        String titulo = Libro.obtenerTexto(scanner, "Ingrese el título del libro a consultar: ");
        Libro libro = Libro.consultarLibroPorTitulo(titulo);
        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void añadirReserva(Scanner scanner) {
        int id = Libro.obtenerNumero(scanner, "Ingrese el ID del libro para hacer la reserva: ");
        Libro libro = Libro.consultarLibroPorId(id);
        if (libro != null) {
            String nombreReserva = Libro.obtenerTexto(scanner, "Ingrese el nombre para la reserva: ");
            if (libro.añadirReserva(nombreReserva)) {
                System.out.println("Reserva añadida correctamente.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void eliminarReserva(Scanner scanner) {
        int id = Libro.obtenerNumero(scanner, "Ingrese el ID del libro para eliminar la reserva: ");
        Libro libro = Libro.consultarLibroPorId(id);
        if (libro != null) {
            String nombreReserva = Libro.obtenerTexto(scanner, "Ingrese el nombre de la reserva a eliminar: ");
            if (libro.eliminarReserva(nombreReserva)) {
                System.out.println("Reserva eliminada correctamente.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }*/
    
    static int getInt(Scanner sc, String prompt)
    {
    	while (true)
    	{
    		System.out.print(prompt);
    		if(sc.hasNextInt())
    		{
    			break;
    		}
    		else
    		{
    			System.err.println("Error: Debe introducir un número entero.");
    			sc.next();
    		}
    	}
    	return sc.nextInt();
    }
    
    static int getInt(Scanner sc, String prompt, String error)
    {
    	sc.nextLine();
    	while (true)
    	{
    		System.out.print(prompt);
    		if(sc.hasNextInt())
    		{
    			break;
    		}
    		else
    		{
    			System.err.println(error);
    			sc.next();
    		}
    	}
    	return sc.nextInt();
    }
    
    static int obtenerAño(Scanner sc, String prompt)
    {
    	String error = "Error: Debes introducir un número superior a 0.";
    	int in;
    	do
    	{
    		in = getInt(sc, prompt, error);
    		if (in < 0) System.err.println(error);
    	} while (in < 0);
    	return in;
    }
}


