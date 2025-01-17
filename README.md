# RetoU4

Usuario: 

El código define la clase Usuario en Java, que representa a un usuario en un sistema de gestión de préstamos de libros. La clase cuenta con los atributos nombre, idUnico, rol y una lista de librosPrestados. Su constructor inicializa estos valores, asegurando que cada usuario tenga un nombre, un identificador único y un rol específico. También incluye un método estático registrarUsuario, que crea y devuelve una nueva instancia de Usuario.
Además, el método listarUsuario permite imprimir una lista de usuarios registrados con su información básica. Por otro lado, el método verificarPrestamo evalúa si un usuario puede realizar un nuevo préstamo según su rol, estableciendo límites de 3 préstamos para estudiantes, 5 para profesores y 1 para invitados. Para ello, recorre una lista de préstamos y cuenta cuántos tiene el usuario en ese momento. Si el número de préstamos actuales es menor al límite permitido, devuelve true; en caso contrario, devuelve false.

Libro:

En mi código, he creado un sistema para gestionar libros, que permite registrar libros, consultar libros por ID o título, listar todos los libros disponibles y gestionar reservas. En la clase Libro, he definido varios atributos como id, titulo, autor, añoPublicacion, cantidad, y un array reservas para almacenar las personas que han reservado los libros.

He implementado un método llamado obtenerAño() para validar que el año de publicación ingresado sea mayor o igual a 1, para evitar valores incorrectos. También he creado los métodos obtenerNumero() y obtenerTexto() para gestionar las entradas del usuario, asegurando que se ingresen números o textos válidos.
