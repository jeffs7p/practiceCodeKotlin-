import java.math.BigDecimal
import java.math.RoundingMode

fun main(args: Array<String>) {
    //Reto número 0
    //fizzBuzz(200)
    //isAnagrama("amor", "romA")
    //fibonacci()
    //serieNumerosPrimos()
    //areaPoligono()
    //invirtiendoCadenas()
    //contandoPalabras()
    //decimalAbinario()
    //recorrerCeros()
    //recorrerPrimeraLetraMasAy()
    expresionesEquilibradas()
}
/* Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una
expresión están equilibrados. */
fun expresionesEquilibradas ()  {
    /* FORMA 1
    println("Ingrese la expresión: ")
    val listInput = readLine()!!.replace(" ", "")
    val expresiones = mapOf("{" to "}", "[" to "]", "(" to ")")
    val listaComprobacion = mutableListOf<String>()
    var result = true

    listInput.forEach {
        val simbolo = it.toString()
        val contieneKey = expresiones.containsKey(simbolo)
        val contieneValue = expresiones.containsValue(simbolo)

        if (contieneKey || contieneValue) {
            if (contieneKey) {
                listaComprobacion.add(simbolo)
            /* Si la lista se queda vacia o el simbolo es cualquiera de  { [ ( el resultado es falso, en esta
            linea se suprimen los sinbolos de listaComprobacion */
            } else if (listaComprobacion.isEmpty() || simbolo != expresiones[listaComprobacion.removeLast()]) {
                result = false
            }
        }
    }
    println(result)
    */
    // FORMA 2
    println("Ingrese la expresión: ")
    val listInput = readLine()!!.replace(" ", "")
    val regexOperacion = Regex("""[a-z+-\/*\^0-9]""")
    var listExpresion = regexOperacion.replace(listInput, "")
    val regexExpresion = Regex("""(\(\))|(\[\])|(\{\})""")

    while (regexExpresion.containsMatchIn(listExpresion)) {
        listExpresion = listExpresion.replace(regexExpresion, "")
    }

    if (listExpresion.isEmpty()) {
        println("true")
    } else {
        println("false")
    }
}

/* Mover la primera letra al final y agregar un ay en cada palabra */
fun recorrerPrimeraLetraMasAy () {
    println("Ingrese lista: ")
    val listInput = readLine()!!.split(" ").map { it }.toMutableList()
    val listFinal = mutableListOf<String>()

    listInput.forEach { palabra ->
        if (palabra != "!" && palabra != "¡" && palabra != "¿" && palabra != "?" ) {
            val size = palabra.length - 1
            val nuevaPalabra = "${palabra.slice(1..size)}${palabra[0]}ay"
            listFinal.add(nuevaPalabra)
        } else {
            listFinal.add(palabra)
        }
    }
    println(listFinal.joinToString(" "))
}
/* Recorrer los 0 al final, preservando el orden de los demás elementos */
fun recorrerCeros () {
    println("Ingrese lista: ")
    val listInput = readLine()!!.split(" ").map { it }.toMutableList()
    val listFinal = mutableListOf<String>()
    val listCeros = mutableListOf<String>()

    for (elemento in listInput) {
        if (elemento == "0") {
            listCeros.add(elemento)
        } else {
            listFinal.add(elemento)
        }
    }
    listFinal.addAll(listCeros)
    println(listFinal)
}
/*Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias
 del lenguaje que lo hagan directamente.*/
fun decimalAbinario () {
    println("Ingrese un número:")
    val num = readLine()!!

    if (isNumber(num) && num.toInt() != 0) {
        var valorInicial = num.toBigDecimal()
        var cociente: BigDecimal
        var resto: BigDecimal
        val numBinario = mutableListOf<Int>()
        while (valorInicial != BigDecimal.ONE) {
            resto = valorInicial % BigDecimal.valueOf(2)
            valorInicial -= resto
            cociente = valorInicial.divide(BigDecimal(2), 0, RoundingMode.DOWN)
            valorInicial -= cociente
            numBinario.add(resto.toInt())
        }
        numBinario.add(1)
        println(numBinario.reversed().joinToString(""))

    } else {
        println("Ingrese un numero válido")
    }
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
fun fizzBuzz (n: Int) {
    val number = 1..n
    val regex = Regex("""\d+\.[1-9]+""")
    val li = 200

    if (n > 0 && n <= li) {
        for (i in number) {
            val multiploTres = i.toDouble() / 3
            val multiploCinco = i.toDouble() / 5
            when {
                !regex.matches(multiploTres.toString()) && !regex.matches(multiploCinco.toString()) -> println("Fizzbuzz")
                !regex.matches(multiploTres.toString()) && regex.matches(multiploCinco.toString()) -> println("Fizz")
                regex.matches(multiploTres.toString()) && !regex.matches(multiploCinco.toString()) -> println("Buzz")
                else -> println(i)
            }
        }
    }
}

