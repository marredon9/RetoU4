# RetoU4

Usuario: 

El código define la clase Usuario en Java, que representa a un usuario en un sistema de gestión de préstamos de libros. La clase cuenta con los atributos nombre, idUnico, rol y una lista de librosPrestados. Su constructor inicializa estos valores, asegurando que cada usuario tenga un nombre, un identificador único y un rol específico. También incluye un método estático registrarUsuario, que crea y devuelve una nueva instancia de Usuario.
Además, el método listarUsuario permite imprimir una lista de usuarios registrados con su información básica. Por otro lado, el método verificarPrestamo evalúa si un usuario puede realizar un nuevo préstamo según su rol, estableciendo límites de 3 préstamos para estudiantes, 5 para profesores y 1 para invitados. Para ello, recorre una lista de préstamos y cuenta cuántos tiene el usuario en ese momento. Si el número de préstamos actuales es menor al límite permitido, devuelve true; en caso contrario, devuelve false.
