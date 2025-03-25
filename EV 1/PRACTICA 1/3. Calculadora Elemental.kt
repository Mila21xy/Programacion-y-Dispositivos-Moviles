package `PRACTICA 1`

/*  
    Autor: Angela Milagros Quispe Huanca  
    Curso: Programación De Dispositivos Móviles  
*/

// Función que imprime el menú de operaciones disponibles para el usuario  
fun mostrarMenu() {
    println("\n*--- Menú ---*")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
    print("Seleccione una opción: ")
}

// Definición de funciones para realizar operaciones matemáticas  

// Función para sumar dos números  
// Utiliza el tipo Number para aceptar tanto enteros (Int) como números decimales (Double, Float)  
fun suma(a: Number, b: Number): Double = a.toDouble() + b.toDouble()

// Función para restar dos números  
// Convierte ambos números a Double para garantizar la precisión en operaciones mixtas  
fun resta(a: Number, b: Number): Double = a.toDouble() - b.toDouble()

// Función para multiplicar dos números  
// Permite realizar multiplicaciones con diferentes tipos numéricos sin problemas de tipo  
fun multiplicacion(a: Number, b: Number): Double = a.toDouble() * b.toDouble()

// Función para dividir dos números, incluye manejo de error para división entre cero  
fun division(a: Number, b: Number): String =
    if (b.toDouble() != 0.0) (a.toDouble() / b.toDouble()).toString()
    else "No se puede dividir entre 0"

// Función que ejecuta la operación seleccionada por el usuario y devuelve el resultado  
fun calculadora(opcion: Int, num1: Number, num2: Number): String {
    // Imprime un encabezado antes de mostrar el resultado  
    println("\nResultado:")
    return when (opcion) {
        1 -> "$num1 + $num2 = ${suma(num1, num2)}" // Realiza la suma  
        2 -> "$num1 - $num2 = ${resta(num1, num2)}" // Realiza la resta  
        3 -> "$num1 * $num2 = ${multiplicacion(num1, num2)}" // Realiza la multiplicación  
        4 -> "$num1 / $num2 = ${division(num1, num2)}" // Realiza la división  
        else -> "Error: opción no reconocida" // Mensaje de error para opción no válida  
    }
}

fun main() {
    // Llama a la función que muestra el menú de opciones al usuario  
    mostrarMenu()

    // Lee la opción seleccionada por el usuario y maneja posibles errores en la entrada  
    // readlnOrNull() devuelve null si no hay entrada o hay error  
    // toIntOrNull() convierte la entrada a Int; si falla, devuelve null  
    // ?: 0 es un operador que asigna 0 si toIntOrNull() devuelve null  
    val opcion = readlnOrNull()?.toIntOrNull() ?: 0

    // Verifica si la opción ingresada es válida (dentro del rango 1 a 4)  
    if (opcion in 1..4) {
        // Solicita al usuario el primer número  
        print("\nIngrese el primer número: ")
        val num1 = readlnOrNull()?.toDoubleOrNull() // Convierte la entrada a Double, o devuelve null si falla  

        // Solicita al usuario el segundo número  
        print("Ingrese el segundo número: ")
        val num2 = readlnOrNull()?.toDoubleOrNull() // Convierte la entrada a Double, o devuelve null si falla  

        // Verifica que los números ingresados sean válidos  
        if (num1 != null && num2 != null) {
            println(calculadora(opcion, num1, num2)) // Llama a la función calculadora y muestra el resultado  
        } else {
            println("Entrada no válida o vacía") // Mensaje de error si la entrada es inválida  
        }
    } else if (opcion == 5) { // Si el usuario selecciona salir  
        println("\nSaliendo de la calculadora...")
    } else {
        println("\nOpción no reconocida.") // Mensaje de error si la opción no es válida  
    }
}

/*  

    Ejemplo de menú:  
    *--- Menú ---*  
    1. Suma  
    2. Resta  
    3. Multiplicación  
    4. División  
    5. Salir  
*/  