/*
    Estudiante: Angela Milagros Quispe Huanca

Ejercicio 3: Figuras
Cree una clase abstracta “shape” la cual contenga las propiedades
área, perímetro y las funciones para calcular estos valores e 
imprimir el resultado de cada operación. Adicional crea tres 
subclases cuadrado, círculo y rectángulo que reciban los valores 
de sus lados, el radio en el caso del círculo con constructores 
secundarios y heredando la clase “shape” y sus métodos. Crear 
instancias de las subclases y ejecutar las operaciones de área 
y perímetro para cada instancia.
*/

// Clase abstracta Figura representando una figura geométrica  
abstract class Figura {  
    // Propiedades para el cálculo del área y el perímetro  
    protected var area: Double = 0.0  
    protected var perimetro: Double = 0.0  

    // Métodos abstractos para calcular área y perímetro  
    abstract fun calcularArea()  
    abstract fun calcularPerimetro()  

    // Método para mostrar los resultados  
    fun mostrarResultados(nombre: String) {  
        println("$nombre:")  
        println("Área: $area")  
        println("Perímetro: $perimetro\n")  
    }  
}  

// Clase Cuadrado que hereda de Figura  
class Cuadrado(private val lado: Double) : Figura() {  
    init {  
        calcularArea()  
        calcularPerimetro()  
    }  

    override fun calcularArea() {  
        area = lado * lado  
    }  

    override fun calcularPerimetro() {  
        perimetro = 4 * lado  
    }  
}  

// Clase Circulo que hereda de Figura  
class Circulo(private val radio: Double) : Figura() {  
    init {  
        calcularArea()  
        calcularPerimetro()  
    }  

    override fun calcularArea() {  
        area = Math.PI * radio * radio  
    }  

    override fun calcularPerimetro() {  
        perimetro = 2 * Math.PI * radio  
    }  
}  

// Clase Rectangulo que hereda de Figura  
class Rectangulo(private val base: Double, private val altura: Double) : Figura() {  
    init {  
        calcularArea()  
        calcularPerimetro()  
    }  

    override fun calcularArea() {  
        area = base * altura  
    }  

    override fun calcularPerimetro() {  
        perimetro = 2 * (base + altura)  
    }  
}  

// Función principal para ejecutar el código  
fun main() {  
    val cuadrado = Cuadrado(4.0)  
    cuadrado.mostrarResultados("Cuadrado")  

    val circulo = Circulo(3.0)  
    circulo.mostrarResultados("Círculo")  

    val rectangulo = Rectangulo(5.0, 3.0)  
    rectangulo.mostrarResultados("Rectángulo")  
}
