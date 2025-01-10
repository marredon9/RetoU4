# RetoU4
Diseñar e implementar un sistema en Java para gestionar una biblioteca.
El sistema debe incluir funcionalidades para manejar usuarios, libros, préstamos y reservas. El trabajo
debe realizarse en grupos de 4 personas, distribuyendo las responsabilidades de cada
clase entre los miembros del equipo y colaborando mediante Git en Eclipse para integrar
el proyecto.


El sistema debe implementar las siguientes funcionalidades principales:

1. Gestión de usuarios:
    o Registrar usuarios con nombre, ID único, y rol (estudiante, profesor,
    invitado).
    o Listar los usuarios registrados en el sistema.
2. Gestión de libros:
    o Registrar libros con título, autor, ID único, año de publicación y cantidad
    de copias disponibles.
    o Consultar información de un libro por su ID o título.
    o Listar todos los libros disponibles.
3. Gestión de préstamos:
    o Permitir que un usuario realice un préstamo de un libro disponible.
    o Restringir los préstamos según el rol del usuario:
    ▪ Estudiantes: máximo 3 libros.
    ▪ Profesores: máximo 5 libros.
    ▪ Invitados: máximo 1 libro.
    o Marcar la devolución de un libro prestado.
4. Gestión de reservas:
    o Permitir que un usuario reserve un libro si no hay copias disponibles.
    o Al devolver un libro, liberar la primera reserva en la lista y notificar al
    usuario.
5. Programa principal:
    o Implementar un menú interactivo que permita al usuario del sistema
    realizar todas las acciones mencionadas.
    o Registrar las operaciones realizadas y mostrarlas como log en pantalla.

Requisitos técnicos
Clases principales y responsabilidades (una por miembro):
1. Clase Usuario (Miembro 1):
    o Atributos: nombre, ID único, rol, libros prestados (array o lista).
    o Métodos: registrar usuario, listar usuarios, verificar si puede realizar un
    préstamo.
2. Clase Libro (Miembro 2):
    o Atributos: título, autor, ID único, año de publicación, cantidad de copias
    disponibles, lista de reservas.
    o Métodos: registrar libro, consultar libro, listar libros, añadir reserva,
    eliminar reserva.
3. Clase Prestamo (Miembro 3):
    o Atributos: ID de préstamo, libro, usuario, fecha de préstamo, fecha de
    devolución.
    o Métodos: crear préstamo, marcar devolución, validar disponibilidad.
4. Clase Reserva (Miembro 4):
    o Atributos: ID de reserva, usuario, libro, fecha de reserva.
    o Métodos: crear reserva, listar reservas de un libro, liberar reserva.
Clase principal Biblioteca:
    • Integra las funcionalidades de todas las clases anteriores.
    • Implementa un menú interactivo que permita:
        1. Registrar usuarios y libros.
        2. Realizar préstamos y devoluciones.
        3. Gestionar reservas.
        4. Consultar registros.


   Requisitos de uso de Git:
1. Cada miembro debe crear y trabajar en su propia rama de Git.
2. Los commits deben ser frecuentes, con mensajes claros y específicos.
3. El responsable del programa principal debe fusionar las ramas al finalizar,
resolviendo posibles conflictos.
4. El repositorio debe estar subido a GitHub, con todos los cambios registrados y
accesibles.


Entregables al finalizar la práctica:
1. Código fuente en un repositorio de GitHub.
2. Documentación breve en formato README.md explicando las clases, sus
métodos y cómo ejecutar el programa.
3. Log de commits del equipo en GitHub, mostrando las contribuciones de cada
miembro.
