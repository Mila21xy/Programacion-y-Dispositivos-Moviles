package `PRACTICA 1`

/*
    Autor: Angela Milagros Quispe Huanca
    Curso: Programacion De Dispositivos Moviles
*/

/*
Ejercicio 1: Evaluación Empleados
En una determinada empresa, sus empleados son evaluados cada 
seis meses. Los puntos que pueden obtener en la evaluación 
comienzan en 0 y pueden ir aumentando hasta llegar a 10, 
traduciéndose en mejores beneficios. Al final del problema se 
muestra una tabla con los niveles correspondientes a cada
puntuación. La cantidad de dinero conseguida en cada nivel se 
calcula multiplicando el salario mensual por la  división de 
la puntuación del nivel divida entre 10. Escribir un programa 
que lea la puntuación del usuario y su salario mensual e 
imprima su nivel de rendimiento, así como la cantidad de dinero
que recibirá el usuario. 
Ejemplo: Salario 10,000; Puntuación 8.
Dinero = 10,000 * (8/10)= 8000. Resultado: Nivel de Rendimiento Aceptable, Cantidad de Dinero Recibido $8000. 

     +---------------+--------------------+
     |     Nivel     |     Puntuación     |
     +---------------+--------------------+
     |  Inaceptable  |       0 a 3        |
     +---------------+--------------------+
     |   Aceptable   |       4 a 6        |
     +---------------+--------------------+
     |   Meritorio   |       7 a 10       |
     +---------------+--------------------+

*/

// Funcion que evalua que la puntuacion este dentro del rango
fun evaluarRango(puntuacion: Int): Boolean {
    return puntuacion in 0..10
}

// Funcion para evaluar al empleado: entrada el salario y la puntuacion
fun evaluarEmpleados(salario: Double, puntuacion: Int): String {
    // Si la puntuación es inválida, establecerla en "Desconocido" y el dinero en 0
    if (!evaluarRango(puntuacion)) {
        return "Nivel de Rendimiento: Desconocido, Cantidad de Dinero Recibido: $0.00"
    }

    // Calcular el dinero adicional basado en la fórmula de puntuación
    val adicional: Double = salario * (puntuacion / 10.0)

    // Determinar nivel de rendimiento de acuerdo a la puntuación del empleado
    val nivel = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Desconocido"
    }

    // Retornar el resultado en el formato solicitado
    return "Nivel de Rendimiento: $nivel, Cantidad de Dinero Recibido: $${"%.2f".format(adicional)}"
}

fun main() {
    // Evaluar a un empleado
    println(evaluarEmpleados(10000.0,8))
}
