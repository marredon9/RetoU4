# Reto Unidad 4
Reto intermodular de desarrollo de Java y GitHub
El repositorio contiene el código fuente de un programa de Java que simule la gestión de una biblioteca, con funciones de gestión de libros, usuarios, préstamos, y reservas, desarrollado de forma colaborativa entre los 4 integrantes del grupo y con el uso de la herramientas de gestión de versiones Git y GitHub.
## Clases y métodos
La clase Usuario contiene los métodos necesarios tanto para registrar nuevos usuarios como para listar los existentes, además de poder verificar si una instancia de dicha clase puede realizar un nuevo préstamo de un libro.
La clase Libro, a su vez, puede realizar búsquedas de un libro tanto por su título como por su identificador (ID), y a su vez puede listar los libros existentes y añadir nuevos al registro del programa.
La clase Préstamo almacena los préstamos realizados por los usuarios, y tiene implementados los métodos para iniciar, finalizar, y listar prestamos.
La clase Reserva tiene estos mismos métodos implementados para su propia clase en específico, además de un método concreto para contar las reservas existentes de un libro.
Por último, la clase Biblioteca es la clase principal del programa, en la cual el usuario puede realizar todas estas acciones por medio de la consola de Java.
## Ejecución del programa
El código fuente está preparado para su ejecución por medio del editor de código Eclipse IDE for Java Developers.
