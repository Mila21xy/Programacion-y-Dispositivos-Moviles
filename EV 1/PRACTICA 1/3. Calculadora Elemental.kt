/*  
    Autor: Angela Milagros Quispe Huanca  

Ejercicio 3: Calculadora Elemental
Realizar una calculadora  básica suma, resta, multiplicación,
división. Debe imprimir un menú con las opciones incluyendo 
una opción salir. Validar que la opción esté disponible. 
Imprimir resultados. 
Ejemplo de menú:
==== Menú ====
Suma
Resta
Multiplicación
División
Salir.

*/
// Función para mostrar las operaciones disponibles  
fun imprimirOpciones() {  
    println("\n==== Menú ====")  
    println("1. Sumar")  
    println("2. Restar")  
    println("3. Multiplicar")  
    println("4. Dividir")  
    println("5. Salir")  
}  

// Funciones para realizar las operaciones matemáticas  
fun suma(a: Double, b: Double): Double = a + b  
fun resta(a: Double, b: Double): Double = a - b  
fun multiplicacion(a: Double, b: Double): Double = a * b  
fun division(a: Double, b: Double): Double {  
    return if (b != 0.0) {  
        a / b  
    } else {  
        throw ArithmeticException("No se puede dividir entre cero.")  
    }  
}  

fun main() {  
    while (true) {  
        imprimirOpciones() // Mostrar el menú  
        val opcion = readLine()?.toIntOrNull() ?: continue // Leer la opción y validar entrada  

        if (opcion == 5) {  
            println("Saliendo de la calculadora.")  
            break // Salir del bucle si la opción es 5  
        }  

        print("Ingresa el primer número: ")  
        val num1 = readLine()?.toDoubleOrNull() ?: continue  
        print("Ingresa el segundo número: ")  
        val num2 = readLine()?.toDoubleOrNull() ?: continue  

        when (opcion) {  
            1 -> println("Resultado de la suma: ${suma(num1, num2)}")  
            2 -> println("Resultado de la resta: ${resta(num1, num2)}")  
            3 -> println("Resultado de la multiplicación: ${multiplicacion(num1, num2)}")  
            4 -> {  
                try {  
                    println("Resultado de la división: ${division(num1, num2)}")  
                } catch (e: ArithmeticException) {  
                    println(e.message)  
                }  
            }  
            else -> println("Opción inválida. Por favor, elige nuevamente.")  
        }  
    }  
}
