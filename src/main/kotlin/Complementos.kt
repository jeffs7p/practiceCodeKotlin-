fun areaTriangulo (dato: MutableList<String>): Double {
    val base = dato[0].toDouble()
    val altura = dato[1].toDouble()
    return (base * altura) / 2
}
fun areaRectangulo (dato: MutableList<String>): Double {
    val largo = dato[0].toDouble()
    val ancho = dato[1].toDouble()
    return largo * ancho
}
fun areaCuadrado (dato: MutableList<String>): Double {
    val lado = dato[0].toDouble()
    return lado * lado
}
fun isNumber (dato: String): Boolean {
    return dato.toDoubleOrNull() != null
}