/*  
    Estudiante: Angela Milagros Quispe Huanca  
    
Ejercicio 1: Clase para Cuenta Bancaria
Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro.
Implementa métodos set y get para establecer y obtener el saldo, y añade 
un método para realizar retiros que tenga en cuenta el límite de retiro. 
Utilice el set para validar datos.
*/

// Clase que representa una cuenta bancaria  
class CuentaBancaria(  
    private var balance: Double,        // Saldo de la cuenta  
    private var maxRetiro: Double       // Límite de retiro  
) {  
    // Validaciones al crear la cuenta  
    init {  
        require(balance >= 0) { "El saldo inicial no puede ser negativo." }  
        require(maxRetiro > 0) { "El límite de retiro debe ser mayor que cero." }  
    }  

    // Propiedad para acceder y actualizar el balance  
    var saldo: Double  
        get() = balance  
        set(value) {  
            require(value >= 0) { "El saldo no puede ser negativo." }  
            balance = value  
            println("El saldo se ha actualizado a: $balance")  
        }  

    // Método para realizar un retiro  
    fun retirar(monto: Double) {  
        when {  
            monto > balance -> println("Fondos insuficientes para completar el retiro.")  
            monto > maxRetiro -> println("El monto excede el límite de retiro permitido.")  
            else -> {  
                balance -= monto  
                println("Retiro exitoso de: $monto. Saldo restante: $balance")  
            }  
        }  
    }  
}  

fun main() {  
    // Crear una cuenta con saldo inicial y límite de retiro  
    val cuenta = CuentaBancaria(1000.0, 300.0)  

    // Mostrar saldo actual  
    println("Saldo actual: ${cuenta.saldo}")  

    // Intentar realizar retiros  
    cuenta.retirar(400.0) // Excede límite de retiro  
    cuenta.retirar(200.0) // Retiro exitoso  
    println("Saldo después del retiro: ${cuenta.saldo}")  
}
