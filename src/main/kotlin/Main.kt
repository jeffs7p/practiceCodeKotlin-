fun main(args: Array<String>) {
    //Reto número 0
    //fizzBuzz()
    //Reto número 1
    //isAnagrama("amor", "romA")
    //Reto número 2
    //fibonacci()
    //serieNumerosPrimos()
    //areaPoligono()
    //invirtiendoCadenas()
    contandoPalabras()
}
/* Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 - Los signos de puntuación no forman parte de la palabra.
 - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.*/
fun contandoPalabras () {
    val input = readLine()!!.split(" ").map { it }.toMutableList()
    val regexInput = Regex("""[a-zA-z]+""")
    val mapPalabras = mutableMapOf<String, Int>()

    input.forEach {
        val palabra = regexInput.find(it)!!.value.lowercase()

        if (!mapPalabras.containsKey(palabra)) {
            mapPalabras.put(palabra, 1)
        } else {
            val num = mapPalabras.get(palabra)!! + 1
            mapPalabras.replace(palabra, num)
        }
    }
    mapPalabras.forEach { palabra ->
        println("${palabra.key}: se ha repetido ${palabra.value} ${if(palabra.value == 1) "vez" else "veces"}")
    }
}

/* Invierta el orden de una cadena de texto sin usar funciones propias del lenguaje */
fun invirtiendoCadenas () {
    val text = readLine()!!.toCharArray()
    val size = text.size - 1
    for (i in size downTo 0) {
        print(text[i])
    }
}
fun areaPoligono () {
    val datos = readLine()?.split(" ")?.map { it }?.toMutableList()
    val sonNumeros = mutableListOf<Boolean>()
    var numOk = false
    var tipoPoligono = ""

    // Se comprueba que los datos ingresados son números
    if (datos != null) {
        for (i in datos) {
            val comprobacion = isNumber(i)
            sonNumeros.add(comprobacion)
        }
    }
    if (!sonNumeros.contains(false)) { numOk = true}

    // Se comprueba tipo de polígono
    if (datos?.size == 2) {
        println("1: Triángulo   2: Rectángulo")
        val datoIngresado = readLine()?.toInt()
        if (datoIngresado == 1) {
            tipoPoligono = "Triángulo"
        } else if (datoIngresado == 2) {
            tipoPoligono = "Rectángulo"
        } else {
            tipoPoligono = "ninguno"
        }
    }

    // Resultados
    when {
        datos.isNullOrEmpty() -> println("No existen datos")
        !numOk -> println("Ingrese números")
        datos.size == 1 -> println("El área del cuadrado es: ${ areaCuadrado(datos) }")
        tipoPoligono == "Triángulo" -> println("El área del triángulo es: ${ areaTriangulo(datos)}")
        tipoPoligono == "Rectángulo" -> println("El área del rectángulo es: ${ areaRectangulo(datos)}")
        tipoPoligono == "ninguno" -> println("No se seleccionó tipo de polígono")
    }
}
fun serieNumerosPrimos () {
    (1..100).forEach {
        val result = esNumeroPrimo(it)
        if (result) {
            print("$it, ")
        }
    }
}
fun fibonacci () {
    var numA: Long = 0
    var numB: Long = 1
    repeat(50) {
       print("$numA, ")
       val numPrint = numA + numB
       numA = numB
       numB = numPrint
    }
}
fun isAnagrama (palabra1: String, palabra2: String ): Boolean {
    println("Mi respuesta")
    val order1 = palabra1.lowercase().toMutableList().sorted()
    val order2 = palabra2.lowercase().toMutableList().sorted()
    val resultado = order1 == order2
    println(resultado)
    return resultado
}
fun fizzBuzz () {
    println("Mi respuesta")
    val number = 1..100
    val regex = Regex("""\d+\.[1-9]+""")

    for (i in number) {
        val multiploTres = i.toDouble() / 3
        val multiploCinco = i.toDouble() / 5
        when {
            !regex.matches(multiploTres.toString()) && !regex.matches(multiploCinco.toString()) -> println("fizzbuzz")
            !regex.matches(multiploTres.toString()) && regex.matches(multiploCinco.toString()) -> println("fizz")
            regex.matches(multiploTres.toString()) && !regex.matches(multiploCinco.toString()) -> println("buzz")
            else -> println(i)
        }
    }
    println()
    println()
    println("Resultado")
    for (index in 1..100) {
        val divisibleByThree = index % 3 == 0
        val divisibleByFive = index % 5 == 0
        if (divisibleByThree && divisibleByFive) {
            println("fizzbuzz")
        } else if (divisibleByThree) {
            println("fizz")
        } else if (divisibleByFive) {
            println("buzz")
        } else {
            println(index)
        }
    }
}

