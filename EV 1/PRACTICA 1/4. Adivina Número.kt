/*
    Autor: Angela Milagros Quispe Huanca

Ejercicio 4: Adivina Número
Escribe un programa que genere un número aleatorio entre 1 y 30,
luego pida al usuario que adivine el número. Proporciona pistas 
indicando si el número a adivinar es mayor o menor que el número
ingresado por el usuario. Continúa solicitando intentos hasta 
que el usuario adivine correctamente el número.Tienes 5 intentos,
si se acaba debe imprimir game over. De lo contrario mostrar un
mensaje de felicitación por ganar el juego.
*/


// Importación necesaria para números aleatorios  
import kotlin.random.Random  

// Función que crea y devuelve un número aleatorio entre 1 y 30  
fun generarNumeroSecreto(): Int {  
    return Random.nextInt(1, 31) // El límite superior es exclusivo  
}  

// Función principal que controla el flujo del juego  
fun main() {  
    val numeroSecreto = generarNumeroSecreto()  
    var intentos = 5  

    println("¡Bienvenido al juego! Tienes $intentos intentos para adivinar el número entre 1 y 30.")  

    while (intentos > 0) {  
        print("Introduce tu adivinanza: ")  
        val adivinanza = readLine()?.toIntOrNull()  

        // Validar la entrada del usuario  
        if (adivinanza == null) {  
            println("Por favor, ingresa un número válido.")  
            continue  
        }  

        // Comprobar si el número adivinado es correcto  
        when {  
            adivinanza == numeroSecreto -> {  
                println("¡Felicitaciones! Has adivinado el número correctamente.")  
                return  
            }  
            adivinanza < numeroSecreto -> println("El número secreto es mayor.")  
            else -> println("El número secreto es menor.")  
        }  

        intentos-- // Reducir el número de intentos restantes  
        println("Te quedan $intentos intentos.")  

        // Si se acabaron los intentos, terminar el juego  
        if (intentos == 0) {  
            println("¡Game Over! El número secreto era $numeroSecreto.")  
        }  
    }
}
