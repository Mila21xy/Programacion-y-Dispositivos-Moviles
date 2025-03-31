/*
    Estudiante: Angela Milagros Quispe Huanca
    
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

// Función que verifica que la puntuación esté en el rango adecuado  
fun esPuntuacionValida(puntuacion: Int): Boolean {  
    return puntuacion in 0..10  
}  

// Función para calcular el nivel y el dinero del empleado  
fun calcularEvaluacion(salarioMensual: Double, puntuacion: Int): String {  
    if (!esPuntuacionValida(puntuacion)) {  
        return "Nivel de Rendimiento: Desconocido, Cantidad de Dinero Recibido: $0.00"  
    }  

    val dineroGanado = salarioMensual * (puntuacion / 10.0)  
    val nivelRendimiento = when (puntuacion) {  
        in 0..3 -> "Inaceptable"  
        in 4..6 -> "Aceptable"  
        in 7..10 -> "Meritorio"  
        else -> "Desconocido"  
    }  

    return "Nivel de Rendimiento: $nivelRendimiento, Cantidad de Dinero Recibido: $${"%.2f".format(dineroGanado)}"  
}  

fun main() {  
    // Solicitar la puntuación y el salario del empleado  
    val salario = 10000.0  
    val puntuacion = 8  

    // Evaluar al empleado y mostrar el resultado  
    println(calcularEvaluacion(salario, puntuacion))  
}  
