/*  
    Estudiante: Angela Milagros Quispe Huanca  

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

abstract class MaterialBiblioteca(  
    val titulo: String,  
    val autor: String,  
    val añoPublicacion: Int  
) {  
    abstract fun mostrarDetalles()  
}  

class Libro(  
    titulo: String,  
    autor: String,  
    añoPublicacion: Int,  
    private val genero: String,  
    private val numPaginas: Int  
) : MaterialBiblioteca(titulo, autor, añoPublicacion) {  
    override fun mostrarDetalles() {  
        println("Título: $titulo, Autor: $autor, Año de Publicación: $añoPublicacion, Género: $genero, Número de Páginas: $numPaginas")  
    }  
}  

class Revista(  
    titulo: String,  
    autor: String,  
    añoPublicacion: Int,  
    private val issn: String,  
    private val volumen: Int,  
    private val numero: Int,  
    private val editorial: String  
) : MaterialBiblioteca(titulo, autor, añoPublicacion) {  
    override fun mostrarDetalles() {  
        println("Título: $titulo, Autor: $autor, Año de Publicación: $añoPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")  
    }  
}  

data class Usuario(val nombre: String, val apellido: String, val edad: Int)  

interface GestionBiblioteca {  
    fun agregarMaterial(material: MaterialBiblioteca)  
    fun agregarUsuario(usuario: Usuario)  
    fun prestar(usuario: Usuario, material: MaterialBiblioteca)  
    fun devolver(usuario: Usuario, material: MaterialBiblioteca)  
    fun listarMateriales()  
    fun listarPorUsuario(usuario: Usuario)  
}  

class Biblioteca : GestionBiblioteca {  
    private val materialesDisponibles = mutableListOf<MaterialBiblioteca>()  
    private val usuariosPrestamos = mutableMapOf<Usuario, MutableList<MaterialBiblioteca>>()  

    override fun agregarMaterial(material: MaterialBiblioteca) {  
        materialesDisponibles.add(material)  
    }  

    override fun agregarUsuario(usuario: Usuario) {  
        usuariosPrestamos[usuario] = mutableListOf()  
    }  

    override fun prestar(usuario: Usuario, material: MaterialBiblioteca) {  
        if (materialesDisponibles.contains(material)) {  
            usuariosPrestamos[usuario]?.add(material)  
            materialesDisponibles.remove(material)  
            println("Material prestado: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")  
        } else {  
            println("Material no disponible para préstamo.")  
        }  
    }  

    override fun devolver(usuario: Usuario, material: MaterialBiblioteca) {  
        if (usuariosPrestamos[usuario]?.contains(material) == true) {  
            usuariosPrestamos[usuario]?.remove(material)  
            materialesDisponibles.add(material)  
            println("Material devuelto: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")  
        } else {  
            println("El usuario no tiene prestado este material.")  
        }  
    }  

    override fun listarMateriales() {  
        println("Materiales disponibles:")  
        if (materialesDisponibles.isEmpty()) {  
            println("No hay materiales disponibles.")  
        } else {  
            materialesDisponibles.forEach { it.mostrarDetalles() }  
        }  
    }  

    override fun listarPorUsuario(usuario: Usuario) {  
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")  
        val materiales = usuariosPrestamos[usuario]  
        if (materiales.isNullOrEmpty()) {  
            println("No tiene materiales en préstamo.")  
        } else {  
            materiales.forEach { it.mostrarDetalles() }  
        }  
    }  
}  

fun main() {  
    val biblioteca = Biblioteca()  

    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Ficción", 400)  
    val revista1 = Revista("Time", "Varios", 2023, "1234-5678", 98, 12, "Time Inc.")  
    val usuario1 = Usuario("Laura", "Martínez", 30)  

    biblioteca.agregarMaterial(libro1)  
    biblioteca.agregarMaterial(revista1)  
    biblioteca.agregarUsuario(usuario1)  

    biblioteca.listarMateriales()  

    biblioteca.prestar(usuario1, libro1)  
    biblioteca.listarMateriales()  
    biblioteca.listarPorUsuario(usuario1)  

    biblioteca.devolver(usuario1, libro1)  
    biblioteca.listarMateriales()  
    biblioteca.listarPorUsuario(usuario1)  
}  
