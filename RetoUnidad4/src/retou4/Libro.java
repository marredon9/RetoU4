package retou4;

import java.util.Scanner;

public class Libro {
    int id;
    String titulo;
    String autor;
    int añoPublicacion;
    String[] reservas; 
    int cantidad;
    static Libro[] libros = new Libro[10]; 
    static int cantidadLibros = 0; 

    // Constructor
    public Libro(int id, String titulo, String autor, int añoPublicacion, int cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.cantidad = cantidad;
        this.reservas = new String[cantidad];  
        
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public String[] getReservas() {
        return reservas;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año: " + añoPublicacion + ", Cantidad: " + cantidad + ", Reservas: " + getCantidadReservas();
    }

    public int getCantidadReservas() {
        int count = 0;
        for (String reserva : reservas) {
            if (reserva != null) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean registrarLibro(int id, String titulo, String autor, int añoPublicacion, int cantidad) {
        if (cantidadLibros < libros.length) {
            libros[cantidadLibros] = new Libro(id, titulo, autor, añoPublicacion, cantidad);
            cantidadLibros++;
            return true;
        } else {
            System.out.println("No hay espacio para más libros.");
            return false;
        }
    }
    
    public static Libro consultarLibroPorId(int id) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getId() == id) {
                return libros[i];
            }
        }
        return null; 
    }

    public static Libro consultarLibroPorTitulo(String titulo) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                return libros[i];
            }
        }
        return null; 
    }
    
    public static void mostrarLibros() {
        if (cantidadLibros == 0) {
            System.out.println("No hay libros registrados.");
        } else {
            for (int i = 0; i < cantidadLibros; i++) {
                System.out.println(libros[i]);
            }
        }
    }
    
    public boolean añadirReserva(String nombreReserva) {
        for (int i = 0; i < cantidad; i++) {
            if (reservas[i] == null) {
                reservas[i] = nombreReserva;
                System.out.println("Reserva añadida para el libro: " + titulo);
                return true;
            }
        }
        System.out.println("No hay copias disponibles para reservar.");
        return false;
    }
    
    public boolean eliminarReserva(String nombreReserva) {
        for (int i = 0; i < cantidad; i++) {
            if (reservas[i] != null && reservas[i].equalsIgnoreCase(nombreReserva)) {
                reservas[i] = null;
                System.out.println("Reserva eliminada para el libro: " + titulo);
                return true;
            }
        }
        System.out.println("No se encontró la reserva para el libro: " + titulo);
        return false;
    }
    
    public static int obtenerNumero(java.util.Scanner scanner, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt(); 
                scanner.nextLine(); 
                return numero;
            } else {
                System.out.println("Error: Debes ingresar un número. Inténtalo de nuevo.");
                scanner.nextLine(); 
            }
        }
    }

    public static String obtenerTexto(java.util.Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    public static int obtenerAño(Scanner scanner, String mensaje) {
        int año;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                año = scanner.nextInt(); 
                scanner.nextLine(); 

                if (año >= 1) {
                    return año;
                } else {
                    System.out.println("Error: El año debe ser mayor o igual a 1.");
                }
            } else {
                System.out.println("Error: Debes ingresar un número. Inténtalo de nuevo.");
                scanner.nextLine(); 
            }
        }
    }


}
