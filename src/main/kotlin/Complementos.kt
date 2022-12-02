fun isNumber (dato: String): Boolean {
    return dato.toDoubleOrNull() != null
}
fun esNumeroPrimo (valor: Int): Boolean {
    var count = 0
    var comprobacion = false
    if (valor < 2) {
        comprobacion = true
    }
    for (i in 2..100) {
        if (valor % i == 0) {
            count += 1
        }
    }
    if (count == 1) {
        comprobacion = true
    }
    //println(comprobacion)
    return comprobacion
}
