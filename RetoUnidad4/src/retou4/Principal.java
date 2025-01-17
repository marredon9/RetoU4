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
						operacion = 0;
						break;
					case 3:
						//LISTAR LIBROS
						System.out.println("Libros disponibles:");
						Libro.mostrarLibros();
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
			case 3:
				//GESTIÓN DE PRÉSTAMOS
				while (true)
				{
					System.out.println();
					int operacion = getInt(sc, "Introduce la gestión de préstamos a realizar:\n"
							+ "[0] Volver.\n"
							+ "[1] Iniciar préstamo.\n"
							+ "[2] Finalizar préstamo.\n");
					switch (operacion)
					{
					case 0:
						break;
					case 1:
						//REALIZAR PRÉSTAMO
						Libro prestado;
						Usuario usuario = null;
						if (Libro.contarLibros() == 0)
						{
							System.out.println("No existen libros para prestar.");
							break;
						}
						while (true)
						{
							Libro.mostrarLibros();
							int id_libro = getInt(sc, "Introduce el ID del libro a tomar prestado: ");
							prestado = Libro.consultarLibroPorId(id_libro);
							if (prestado == null)
							{
								System.out.println("No existe ningún libro con ese ID.");
							}
							else
							{
								if (prestado.cantidad == 0) System.out.println("No hay unidades disponibles de ese libro.");
								break;
							}
						}
						if (prestado.cantidad == 0) break;
						while (true)
						{
							Usuario.listarUsuario();
							int id_usuario = getInt(sc, "Introduce el ID del usuario que va a tomar prestado el libro: ");
							//buscar usuario
							for (int i = 0; i < Usuario.usuarios.length; i++)
							{
								if (Usuario.usuarios[i] == null) break;
								if (id_usuario == Usuario.usuarios[i].idUnico)
								{
									usuario = Usuario.usuarios[i];
								}
							}
							if (usuario == null)
							{
								System.out.println("No existe ningún usuario con ese ID.");
							}
							else
							{
								if (!usuario.verificarPrestamo()) System.out.println("El usuario no tiene préstamos disponibles.");
								break;
							}
						}
						if (!usuario.verificarPrestamo()) break;
						System.out.print("Introduzca la fecha de inicio del préstamo: ");
						String fecha = sc.next();
						int id_prestamo = Prestamo.cont_ids;
						Prestamo.iniciarPrestamo(prestado, usuario, fecha);
						System.out.println("Se ha iniciado un préstamo con el ID " + id_prestamo);
						operacion = 0;
						break;
					case 2:
						//FINALIZAR PRÉSTAMO
						int prestamo;
						while (true)
						{
							Prestamo.listarPrestamos();
							prestamo = getInt(sc, "Introduce el ID del prestamo a finalizar: ");
							Prestamo finalizar_prestamo = null;
							//Buscar préstamo por ID
							for (int i = 0; i < Prestamo.prestamos.length; i++)
							{
								if (Prestamo.prestamos[i] == null) break;
								if (Prestamo.prestamos[i].id == prestamo)
								{
									finalizar_prestamo = Prestamo.prestamos[i];
									break;
								}
							}
							if (finalizar_prestamo == null)
							{
								System.out.println("No se ha encontrado ningún préstamo con ese ID.");
								break;
							}
							System.out.print("Introduce la fecha del fin del préstamo: ");
							String fecha_fin = sc.next();
							finalizar_prestamo.finalizarPrestamo(fecha_fin);
							System.out.println("Se ha finalizado el préstamo.");
						}
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
			case 4:
				//GESTIÓN DE RESERVAS
				while (true)
				{
					int operacion = getInt(sc, "Introduce la gestión de reservas a realizar\n"
							+ "[0] Volver.\n"
							+ "[1] Crear reserva.\n"
							+ "[2] Listar reservas.\n"
							+ "[3] Liberar reserva.");
					switch (operacion)
					{
					case 0:
						break;
					case 1:
						//CREAR RESERVA
						Libro libro;
						Usuario usuario = null;
						if (Libro.contarLibros() == 0)
						{
							System.out.println("No existen libros para reservar.");
							break;
						}
						while (true)
						{
							Libro.mostrarLibros();
							int id_libro = getInt(sc, "Introduce el ID libro a reservar: ");
							libro = Libro.consultarLibroPorId(id_libro);
							if (libro == null) System.out.println("No existe ningún libro con ese ID.");
							break;
						}
						if (libro == null) break;
						while (true)
						{
							Usuario.listarUsuario();
							int id_usuario = getInt(sc, "Introduce el ID del usuario que va a reservar el libro: ");
							//buscar usuario
							for (int i = 0; i < Usuario.usuarios.length; i++)
							{
								if (Usuario.usuarios[i] == null) break;
								if (id_usuario == Usuario.usuarios[i].idUnico)
								{
									usuario = Usuario.usuarios[i];
								}
							}
							if (usuario == null)
							{
								System.out.println("No existe ningún usuario con ese ID.");
							}
							else
							{
								break;
							}
						}
						System.out.print("Introduce la fecha de la reserva: ");
						String fecha = sc.next();
						Reserva.crearReserva(usuario, libro, fecha);
						operacion = 0;
						break;
					case 2:
						//LISTAR RESERVAS
						Reserva.listarReservas();
						operacion = 0;
						break;
					case 3:
						//LIBERAR RESERVA
						Reserva.listarReservas();
						sc.nextLine();
						int id = getInt(sc, "Introduce el ID de la reserva a liberar: ");
						Reserva.liberarReserva(operacion);
						operacion = 0;
						break;
					default:
						//ERROR
						System.out.println("La opción introducida no es válida.");
						break;
					}
					
					if (operacion == 0) break;
				}
				break;
			default:
				System.out.println("Error: La opción elegida no es válida.");
				break;
			}
			if (opcion == 0) break;
		}
		System.out.println("Se ha salido del programa. Hasta pronto!");
    }
	
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


