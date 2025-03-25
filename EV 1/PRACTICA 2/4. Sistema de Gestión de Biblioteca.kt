package `PRACTICA 2`

/*  
    Autor: Angela Milagros Quispe Huanca  
    Curso: Programación De Dispositivos Móviles  
*/

/*
Ejercicio 4: Sistema de Gestión de Biblioteca
Diseña un sistema de gestión de biblioteca que incluya las siguientes 
clases e interfaces:
Material: Una clase base abstracta que tiene propiedades como título, 
autor, anioPublicacion,  y un método abstracto para mostrarDetalles().
Libro: Una subclase de Material que tiene propiedades adicionales como 
género, número páginas y un método para mostrar los detalles del libro.
Revista: Una subclase de Material que tiene propiedades como issn,
volumen, número, editorial y un método para mostrar los detalles de la
revista.
Usuario: Una data class que tiene propiedades como nombre, apellido, edad.
IBiblioteca:Una interfaz que contenga los métodos registrar material,
registrar usuario, préstamo, devolución, mostrar materiales disponibles y
mostrar materiales reservados por usuario.
Biblioteca: Una clase que gestiona las operaciones de préstamo y devolución.
Debe implementar la interfaz anterior. Debe tener una lista de materiales 
disponibles, así como un Map de usuarios donde la clase es el usuario y el
valor una lista de materiales que tiene en préstamo.
Crear instancias de las subclases y ejecutar las operaciones de préstamo y
devolución para cada instancia. 
OJO: En este caso se cambio 'anioPublicación' por 'fechaPublicacion'
*/

// Clase base abstracta para materiales de la biblioteca
abstract class Material(
    val titulo: String,
    val autor: String,
    val fechaPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    fechaPublicacion: Int,
    private val genero: String,
    private val numeroPaginas: Int
) : Material(titulo, autor, fechaPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $fechaPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    fechaPublicacion: Int,
    private val issn: String,
    private val volumen: Int,
    private val numero: Int,
    private val editorial: String
) : Material(titulo, autor, fechaPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $fechaPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

// Data class Usuario
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz para las funciones de la biblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

// Implementación de la biblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuarios.containsKey(usuario)) {
            usuarios[usuario] = mutableListOf()
            println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("El usuario ya está registrado.")
        }
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("Material prestado: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("Material no disponible para préstamo.")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("El usuario no tiene prestado este material.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles.")
        } else {
            materialesDisponibles.forEach { it.mostrarDetalles() }
        }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
        val materiales = usuarios[usuario]
        if (materiales.isNullOrEmpty()) {
            println("No tiene materiales en préstamo.")
        } else {
            materiales.forEach { it.mostrarDetalles() }
        }
    }
}

// Función principal
fun main() {
    val biblioteca = Biblioteca()

    val libro1 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios", 2024, "1234-5678", 102, 5, "NatGeo Publishing")
    val usuario1 = Usuario("Carlos", "Gómez", 25)

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    biblioteca.mostrarMaterialesDisponibles()

    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
}

/*
    Sistema de Gestión de Biblioteca: Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces:

    - Material: Una clase base abstracta que tiene propiedades como título, autor, anioPublicacion,  y un metodo abstracto para mostrarDetalles().
    - Libro: Una subclase de Material que tiene propiedades adicionales como género, número páginas y un metodo para mostrar los detalles del libro.
    - Revista: Una subclase de Material que tiene propiedades como issn, volumen, número, editorial y un metodo para mostrar los detalles de la revista.
    - Usuario: Una data class que tiene propiedades como nombre, apellido, edad.
    - IBiblioteca:Una interfaz que contenga los métodos registrar material, registrar usuario, préstamo, devolución,
    mostrar materiales disponibles y mostrar materiales reservados por usuario.
    - Biblioteca: Una clase que gestiona las operaciones de préstamo y devolución. Debe implementar la interfaz anterior.
    Debe tener una lista de materiales disponibles, así como un Map de usuarios donde la clase es el usuario y el valor una lista de materiales que tiene en préstamo.

    Crear instancias de las subclases y ejecutar las operaciones de préstamo y devolución para cada instancia.
*/



