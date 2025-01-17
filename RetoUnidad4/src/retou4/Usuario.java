package retou4;

//import java.util.*;

public class Usuario {
	static int cont_ids;
	String nombre;
	String idUnico;
	String rol;
	//List<String> librosPrestados;
	Prestamo[] librosPrestados;
	static Usuario[] usuarios = new Usuario[16];
	
	
	public Usuario (String nombre, String idUnico, String rol, int prestamos) {
		this.nombre = nombre;
		this.idUnico = idUnico;
		this.rol = rol;
		this.librosPrestados = new Prestamo[prestamos];
	}
	
	public static void registrarUsuario(String nombre, String idUnico, String rol) {
		if (usuarios[usuarios.length - 1] != null)
		{
			System.out.println("Se ha alcanzado el límite de usuarios a registrar."); //Si el último usuario en la lista no es nulo, no hay huecos libres.
			return;
		}
		int prestamos;
		switch (rol.toLowerCase())
		{
		case "invitado":
			prestamos = 1;
			break;
		case "estudiante":
			prestamos = 3;
			break;
		case "profesor":
			prestamos = 5;
			break;
		default:
			prestamos = 0;
			System.err.println("ERROR: Se ha creado un usuario de rol desconocido.");
		}
		
		//Registrar usuario en lista
		for (int i = 0; i < usuarios.length; i++)
		{
			if (usuarios[i] == null)
			{
				usuarios[i] = new Usuario(nombre, idUnico, rol, prestamos);
				break;
			}
		}
		
	}
	
	public void listarUsuario(Usuario[] usuarios) {
		System.out.println("------Usuarios Registrados:------");
		 for (Usuario usuario : usuarios) {
			 System.out.println("Nombre: " + usuario.nombre + "\n" + " ID: " + usuario.idUnico + "\n"  + "Rol: " + usuario.rol);
		 }
	}
	
	public boolean verificarPrestamo() {
		return (this.librosPrestados[this.librosPrestados.length - 1] != null);
	}
}

