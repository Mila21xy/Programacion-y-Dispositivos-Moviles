/*  
    Estudiante: Angela Milagros Quispe Huanca

Ejercicio 2: Piedra, Papel, Tijera
Escriba un programa que realice el juego de piedra, 
papel o tijera. La computadora debe elegir de manera
aleatoria la opción a elegir. Después debe preguntar
al usuario que opción quiere. Imprimir si ganó, 
perdió o empató.
*/

// Importación para manejar la aleatoriedad  
import kotlin.random.Random  

// Función para seleccionar aleatoriamente la opción de la computadora  
fun seleccionComputadora(): String {  
    val opciones = arrayOf("piedra", "papel", "tijera")  
    return opciones[Random.nextInt(opciones.size)]  
}  

// Función para obtener la elección del jugador, asegurando que sea válida  
fun seleccionJugador(): String {  
    print("Selecciona piedra, papel o tijera: ")  
    val seleccion = readLine()?.lowercase() ?: ""  
    
    // Verificar que la selección sea válida  
    return if (seleccion in listOf("piedra", "papel", "tijera")) {  
        seleccion  
    } else {  
        println("Selección inválida. Intenta de nuevo.")  
        seleccionJugador() // Volver a preguntar en caso de selección inválida  
    }  
}  

// Función principal para ejecutar el juego  
fun main() {  
    val computadora = seleccionComputadora()  
    val jugador = seleccionJugador()  
    
    println("La computadora eligió: $computadora")  
    println("Tu elegiste: $jugador")  

    // Determinar el resultado del juego  
    when {  
        computadora == jugador -> println("¡Es un empate!")  
        (computadora == "piedra" && jugador == "tijera") ||   
        (computadora == "papel" && jugador == "piedra") ||   
        (computadora == "tijera" && jugador == "papel") -> println("Perdiste.")  
        else -> println("¡Ganaste!")  
    }  
}  
