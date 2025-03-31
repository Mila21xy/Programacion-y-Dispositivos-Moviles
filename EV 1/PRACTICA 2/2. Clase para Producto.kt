/*
    Estudiante: Angela Milagros Quispe Huanca

Ejercicio 1: Clase para Producto
Diseña una clase Producto que tenga un precio y un descuento aplicable.
Implementa métodos set y get para establecer y obtener el precio y el 
descuento, y añade un método para calcular el precio final después de 
aplicar el descuento. Utilice el set para validar datos.
*/

// Clase que representa un producto con un precio y un descuento  
class Producto(  
    private var _precio: Double,  // Precio del producto  
    private var _descuento: Int    // Descuento en porcentaje (0-100)  
) {  
    // Inicializador que valida los valores  
    init {  
        if (_precio <= 0) {  
            println("Precio inválido. Se establece en 1.0 por defecto.")  
            _precio = 1.0  
        }  
        if (_descuento !in 0..100) {  
            println("Descuento inválido. Se establece en 0 por defecto.")  
            _descuento = 0  
        }  
    }  

    // Método para establecer un nuevo precio con validación  
    fun setPrecio(nuevoPrecio: Double) {  
        if (nuevoPrecio > 0) {  
            _precio = nuevoPrecio  
            println("Precio actualizado: $_precio")  
        } else {  
            println("El precio debe ser mayor que 0.")  
        }  
    }  

    // Método para obtener el precio  
    fun getPrecio(): Double {  
        return _precio  
    }  

    // Método para establecer un nuevo descuento con validación  
    fun setDescuento(nuevoDescuento: Int) {  
        if (nuevoDescuento in 0..100) {  
            _descuento = nuevoDescuento  
            println("Descuento establecido: $_descuento%")  
        } else {  
            println("El descuento debe estar entre 0 y 100.")  
        }  
    }  

    // Método para obtener el descuento  
    fun getDescuento(): Int {  
        return _descuento  
    }  

    // Método para calcular el precio final después de aplicar el descuento  
    fun calcularPrecioFinal(): Double {  
        val descuentoValor = _precio * _descuento / 100  
        return _precio - descuentoValor  
    }  
}  

// Función principal para probar la clase  
fun main() {  
    val producto = Producto(100.0, 15)  
    
    println("Precio original: ${producto.getPrecio()}")  
    println("Descuento: ${producto.getDescuento()}%")  
    println("Precio final: ${producto.calcularPrecioFinal()}")  

    // Modificar precio y descuento  
    producto.setPrecio(80.0)  
    producto.setDescuento(20)  

    println("Nuevo precio final: ${producto.calcularPrecioFinal()}")  
}
