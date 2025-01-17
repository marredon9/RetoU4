package retou4;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar libro");
            System.out.println("2. Consultar libro por ID");
            System.out.println("3. Consultar libro por título");
            System.out.println("4. Listar todos los libros");
            System.out.println("5. Añadir reserva");
            System.out.println("6. Eliminar reserva");
            System.out.println("7. Salir");

            opcion = Libro.obtenerNumero(scanner, "Ingrese el número de la opción: ");
            
            switch (opcion) {
                case 1:
                    registrarLibro(scanner);
                    break;
                case 2:
                    consultarLibroPorId(scanner);
                    break;
                case 3:
                    consultarLibroPorTitulo(scanner);
                    break;
                case 4:
                    Libro.mostrarLibros();
                    break;
                case 5:
                    añadirReserva(scanner);
                    break;
                case 6:
                    eliminarReserva(scanner);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 7);

        scanner.close();*/
        
        
    }

    private static void registrarLibro(Scanner scanner) {
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
}


