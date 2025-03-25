package `PRACTICA 1`

/*
    Autor: Angela Milagros Quispe Huanca
    Curso: Programación De Dispositivos Móviles
*/

/*
Ejercicio 4: Adivina Número
Escribe un programa que genere un número aleatorio entre 1 y 30,
luego pida al usuario que adivine el número. Proporciona pistas 
indicando si el número a adivinar es mayor o menor que el número
ingresado por el usuario. Continúa solicitando intentos hasta 
que el usuario adivine correctamente el número.Tienes 5 intentos,
si se acaba debe imprimir game over. De lo contrario mostrar un
mensaje de felicitación por ganar el juego.
*/

// Importación de la biblioteca para generar números aleatorios
// Referencia: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.random/-random/
import kotlin.random.Random

// Función que genera un número aleatorio en el rango de 1 a 30
fun numeroAleatorio(): Int {
    return Random.nextInt(1, 31) // Genera un número entre 1 y 30 (excluye 31)
}

// Función que verifica si el número ingresado por el usuario es igual al número secreto
fun verificarNumeros(numUsuario: Int, numRandom: Int): Boolean {
    return numUsuario == numRandom
}

// Función que proporciona una pista al usuario si no ha adivinado el número
fun darPista(numUsuario: Int, numSecreto: Int) {
    if (numUsuario < numSecreto) {
        println("El número secreto es mayor.")
    } else {
        println("El número secreto es menor.")
    }
}

fun main() {
    // Generar el número secreto de forma aleatoria
    val numSecreto = numeroAleatorio()

    // Establecer el número máximo de intentos que el usuario tiene
    var intentos = 5

    println("¡Bienvenido al juego de adivinanza!")
    println("\nAdivina un número entre 1 y 30")
    println("Tienes $intentos intentos")

    // Bucle que se ejecuta mientras el usuario tenga intentos disponibles
    while (intentos > 0) {
        print("Ingresa tu número: ")

        // Leer el número ingresado por el usuario y convertirlo a entero
        val intentoUsuario = readlnOrNull()?.toIntOrNull()

        // Validar si la entrada es correcta (debe ser un número entre 1 y 30)
        if (intentoUsuario == null || intentoUsuario !in 1..30) {
            println("Entrada no válida. Por favor, ingresa un número entre 1 y 30.")
            continue
        }

        // Verificar si el número ingresado coincide con el número secreto
        if (verificarNumeros(intentoUsuario, numSecreto)) {
            println("\n¡Felicidades! Adivinaste el número: $numSecreto")
            return // Termina el programa si el usuario adivina correctamente
        } else {
            darPista(intentoUsuario, numSecreto) // Proporciona una pista si no acierta
        }

        // Disminuir el número de intentos restantes
        intentos--

        // Informar al usuario cuántos intentos le quedan o si ha perdido el juego
        if (intentos > 0) {
            println("\n-> Te quedan $intentos intentos\n")
        } else {
            println("\nGame Over..........")
            println("El número correcto era $numSecreto")
        }
    }
}
