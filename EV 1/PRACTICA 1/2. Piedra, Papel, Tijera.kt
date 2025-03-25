package `PRACTICA 1`

/*  
    Autor: Angela Milagros Quispe Huanca
    Curso: Programación De Dispositivos Móviles
*/

/*
Ejercicio 2: Piedra, Papel, Tijera
Escriba un programa que realice el juego de piedra, 
papel o tijera. La computadora debe elegir de manera
aleatoria la opción a elegir. Después debe preguntar
al usuario que opción quiere. Imprimir si ganó, 
perdió o empató.
*/

// Importación para terminar el proceso si es necesario
import kotlin.system.exitProcess

// Función para obtener la elección aleatoria de la computadora
fun eleccionComputador(): String {
    // Lista de opciones que puede elegir la computadora
    val opcionesComputador = listOf("piedra", "papel", "tijera")

    // Retorna una opción aleatoria escogida por la computadora
    return opcionesComputador.random()
}

// Función para obtener la elección del usuario, validando la entrada
fun eleccionPersona(): String {
    print("Elige entre piedra, papel o tijera: ")

    // Leer entrada del usuario y convertirla a minúsculas
    val eleccionPersona = readlnOrNull()?.lowercase() ?: ""

    // Si la elección es válida, la retorna
    if (eleccionPersona in listOf("piedra", "papel", "tijera")) {
        return eleccionPersona
    }

    // Si la elección no es válida, imprime un mensaje y finaliza el programa
    println("¡¡¡Opción no válida!!!")
    println("\nInténtalo de nuevo...")
    exitProcess(0)
}

// Función para determinar el resultado del juego
fun determinarResultado(eleccionPersona: String, eleccionComputadora: String): String {
    return when {
        // Caso de empate: ambas elecciones son iguales
        eleccionPersona == eleccionComputadora -> "¡Empate!"

        // Casos en los que el usuario gana
        (eleccionPersona == "piedra" && eleccionComputadora == "tijera") ||
                (eleccionPersona == "tijera" && eleccionComputadora == "papel") ||
                (eleccionPersona == "papel" && eleccionComputadora == "piedra") -> "¡¡¡Ganaste!!!"

        // Caso contrario, es una derrota
        else -> "Perdiste..."
    }
}

fun main() {
    // Generar la elección aleatoria de la computadora
    val computadora = eleccionComputador()

    // Obtener la elección del usuario
    val persona = eleccionPersona()

    // Mostrar las elecciones de ambos
    println("\nElegiste: $persona")
    println("La computadora eligió: $computadora")

    // Determinar el resultado del juego
    val resultado = determinarResultado(persona, computadora)

    // Mostrar el resultado
    println("\n$resultado")
}
