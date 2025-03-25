package `PRACTICA 2`

/*  
    Autor: Angela Milagros Quispe Huanca  
    Curso: Programación De Dispositivos Móviles  
*/

// Clase CuentaBancaria con saldo y límite de retiro
class CuentaBancaria(
    private var saldo: Number,         // Saldo de la cuenta
    private var limiteRetiro: Number   // Límite de retiro
) {
    // Validaciones iniciales
    init {
        require(saldo.toDouble() >= 0) { "El saldo no puede ser negativo." }
        require(limiteRetiro.toDouble() > 0) { "El límite de retiro debe ser mayor que 0." }
    }

    // Propiedad saldo con validación
    var saldoActual: Number
        get() = saldo
        set(value) {
            require(value.toDouble() >= 0) { "El saldo no puede ser negativo." }
            if (value.toDouble() != saldo.toDouble()) {
                saldo = value
                println("Saldo actualizado: $saldo\n")
            } else {
                println("El saldo no cambió: $saldo\n")
            }
        }

    // Propiedad límite de retiro con validación
    var limiteDeRetiro: Number
        get() = limiteRetiro
        set(value) {
            require(value.toDouble() > 0) { "El límite de retiro debe ser mayor a 0." }
            if (value.toDouble() != limiteRetiro.toDouble()) {
                limiteRetiro = value
                println("Límite de retiro actualizado: $limiteRetiro\n")
            } else {
                println("El límite de retiro no cambió: $limiteRetiro\n")
            }
        }

    // Método para retirar dinero
    fun retirar(monto: Number) {
        val montoDouble = monto.toDouble()
        when {
            montoDouble > saldo.toDouble() -> println("Saldo insuficiente. Faltan ${montoDouble - saldo.toDouble()}\n")
            montoDouble > limiteRetiro.toDouble() -> println("El monto excede el límite de retiro ($limiteRetiro).\n")
            else -> {
                saldo = saldo.toDouble() - montoDouble
                println("Retiro exitoso! Saldo: $saldo\n")
            }
        }
    }
}

// Función principal
fun main() {
    val cuenta = CuentaBancaria(500, 500)

    println("Saldo inicial: ${cuenta.saldoActual}\n")

    cuenta.saldoActual = 100
    cuenta.limiteDeRetiro = 200
    cuenta.retirar(150)
}

/*
    Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro.
    Implementa métodos set y get para establecer y obtener el saldo,
    y añade un metodo para realizar retiros que tenga en cuenta el límite de retiro.
    Utilice el set para validar datos.
*/