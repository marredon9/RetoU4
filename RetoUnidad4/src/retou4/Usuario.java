package retou4;

import java.util.*;

public class Usuario {
	String nombre;
	String idUnico;
	String rol;
	List<String> librosPrestados;
	
	
	public Usuario (String nombre, String idUnico, String rol) {
		this.nombre = nombre;
		this.idUnico = idUnico;
		this.rol = rol;
		this.librosPrestados = new ArrayList<>();
	}
	
	public static Usuario registrarUsuario(String nombre, String idUnico, String rol) {
		return new Usuario (nombre, idUnico, rol);
		
	}
	
	public void listarUsuario(List<Usuario> usuarios) {
		System.out.println("------Usuarios Registrados:------");
		 for (Usuario usuario : usuarios) {
			 System.out.println("Nombre: " + usuario.nombre + "\n" + " ID: " + usuario.idUnico + "\n"  + "Rol: " + usuario.rol);
		 }
	}
	
	public boolean verificarPrestamo(List<Prestamo> prestamos) {
		int limitePrestamos = 0;

		switch (rol.toLowerCase()) {
		case "estudiante":
			limitePrestamos = 3;
			break;
		case "profesor":
			limitePrestamos = 5;
			break;
		case "invitado":
			limitePrestamos = 1;
			break;
		default:
			System.out.println("Rol no valido");
			return false;
		}

		int prestamosActuales = 0;
		for(Prestamo prestamo : prestamos){
			if(prestamo.getUsuario().equals(this)){
				prestamosActuales++;
			}
		}
		return prestamosActuales < limitePrestamos;
	}
}

