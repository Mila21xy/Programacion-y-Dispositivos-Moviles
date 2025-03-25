package `PRACTICA 2`

/*
    Autor: Angela Milagros Quispe Huanca
    Curso: Programación De Dispositivos Móviles
*/
/*
Ejercicio 1: Clase para Producto
Diseña una clase Producto que tenga un precio y un descuento aplicable.
Implementa métodos set y get para establecer y obtener el precio y el 
descuento, y añade un método para calcular el precio final después de 
aplicar el descuento. Utilice el set para validar datos.
*/
// Clase Producto con precio y descuento
class Producto(
    private var precio: Float,  // Precio
    private var descuento: Int  // Descuento (0-100)
) {
    // Validaciones iniciales
    init {
        if (precio <= 0) {
            println("Precio inválido. Se establece en 1 por defecto.")
            precio = 1f
        }
        if (descuento !in 0..100) {
            println("Descuento inválido. Se establece en 0 por defecto.")
            descuento = 0
        }
    }

    // Métodos para modificar precio y descuento con validaciones
    fun setPrecio(nuevoPrecio: Float) {
        if (nuevoPrecio > 0) {
            precio = nuevoPrecio
            println("Nuevo precio: $precio")
        } else {
            println("El precio debe ser mayor a 0.")
        }
    }

    fun setDescuento(nuevoDescuento: Int) {
        if (nuevoDescuento in 0..100) {
            descuento = nuevoDescuento
            println("Nuevo descuento: $descuento%")
        } else {
            println("Descuento fuera de rango (0-100).")
        }
    }

    // Métodos para obtener valores
    fun getPrecio(): Float = precio
    fun getDescuento(): Int = descuento

    // Calcula el precio final con descuento
    fun calcularPrecioFinal(): Float = precio * (1 - descuento / 100f)

    // Muestra la información del producto
    fun imprimirInformacion() {
        println("Precio: $precio | Descuento: $descuento% | Final: ${calcularPrecioFinal()}\n")
    }
}

// Prueba de la clase Producto
fun main() {
    val producto = Producto(100f, 10)
    producto.imprimirInformacion()

    producto.setPrecio(200f)
    producto.setDescuento(15)
    producto.imprimirInformacion()

    producto.setDescuento(120) // Descuento inválido
    producto.imprimirInformacion()
}
