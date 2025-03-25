package `PRACTICA 2`

/*
    Autor: Angela Milagros Quispe Huanca
    Curso: Programación De Dispositivos Móviles
*/

/*
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

// Clase abstracta Shape que representa cualquier figura geométrica
abstract class Shape {
    // Propiedades protegidas para almacenar área y perímetro
    protected var area: Number = 0.0
    protected var perimetro: Number = 0.0

    // Métodos abstractos que deben ser implementados por las subclases para calcular área y perímetro
    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    // Método común para mostrar los resultados de cada figura
    fun imprimirResultados(nombre: String) {
        println("Resultados del $nombre")
        println("Área: $area")
        println("Perímetro: $perimetro\n")
    }
}

// Subclase Cuadrado: Define un cuadrado y hereda de Shape
class Cuadrado(private var lado: Number) : Shape() {

    // Inicialización que valida que el lado sea mayor a 0, asignando 1 como valor por defecto
    init {
        if (lado.toDouble() <= 0) {
            println("Lado inválido. Se asignará 1 por defecto.\n")
            lado = 1
        }
    }

    // Cálculo del área (lado * lado)
    override fun calcularArea() {
        area = lado.toDouble() * lado.toDouble()
    }

    // Cálculo del perímetro (4 * lado)
    override fun calcularPerimetro() {
        perimetro = 4 * lado.toDouble()
    }

    // Método para mostrar los atributos del cuadrado
    fun imprimirAtributos() {
        println("Atributos del Cuadrado:")
        println("Lado: $lado")
    }
}

// Subclase Rectángulo: Define un rectángulo y hereda de Shape
class Rectangulo(private var base: Number, private var altura: Number) : Shape() {

    // Inicialización que valida que la base y la altura sean mayores a 0
    init {
        if (base.toDouble() <= 0) {
            println("Base inválida. Se asignará 1 por defecto.\n")
            base = 1
        }
        if (altura.toDouble() <= 0) {
            println("Altura inválida. Se asignará 1 por defecto.\n")
            altura = 1
        }
    }

    // Cálculo del área (base * altura)
    override fun calcularArea() {
        area = base.toDouble() * altura.toDouble()
    }

    // Cálculo del perímetro (2 * (base + altura))
    override fun calcularPerimetro() {
        perimetro = 2 * (base.toDouble() + altura.toDouble())
    }

    // Método para mostrar los atributos del rectángulo
    fun imprimirAtributos() {
        println("Atributos del Rectángulo:")
        println("Base: $base")
        println("Altura: $altura")
    }
}

// Subclase Círculo: Define un círculo y hereda de Shape
class Circulo(private var radio: Number) : Shape() {

    // Inicialización que valida que el radio sea mayor a 0
    init {
        if (radio.toDouble() <= 0) {
            println("Radio inválido. Se asignará 1 por defecto.\n")
            radio = 1
        }
    }

    // Cálculo del área (π * radio^2)
    override fun calcularArea() {
        area = Math.PI * radio.toDouble() * radio.toDouble()
    }

    // Cálculo del perímetro (2 * π * radio)
    override fun calcularPerimetro() {
        perimetro = 2 * Math.PI * radio.toDouble()
    }

    // Método para mostrar los atributos del círculo
    fun imprimirAtributos() {
        println("Atributos del Círculo:")
        println("Radio: $radio")
    }
}

// Función principal donde se instancian las figuras y se ejecutan las operaciones
fun main() {
    // Creación de un cuadrado
    val cuadrado = Cuadrado(4)
    cuadrado.imprimirAtributos() // Muestra los atributos
    cuadrado.calcularArea()
    cuadrado.calcularPerimetro()
    cuadrado.imprimirResultados("Cuadrado") // Muestra el área y el perímetro

    // Creación de un rectángulo
    val rectangulo = Rectangulo(5, 3)
    rectangulo.imprimirAtributos()
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    rectangulo.imprimirResultados("Rectángulo")

    // Creación de un círculo
    val circulo = Circulo(2.5)
    circulo.imprimirAtributos()
    circulo.calcularArea()
    circulo.calcularPerimetro()
    circulo.imprimirResultados("Círculo")
}
