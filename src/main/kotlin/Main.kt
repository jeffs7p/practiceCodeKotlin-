import java.math.BigDecimal
import java.math.RoundingMode
import java.text.Normalizer
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.pow


fun main(args: Array<String>) {
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
    //expresionesEquilibradas()
    //eliminandoCaracteres()
   // esUnPolindromo()
    //factorialNumero()
    //numeroAmstrong()
    //calcularDias()
    //mayusculaPrimeraLetra()
    //separacionElementos()
    //carreraObstaculos()
    //dibujarTriangulo()
    esCapicua()
}
/*
Realizar una función que reciba un numero ingresado por el usuario y averigüe si el número es
capicúa o no (Por ejemplo: 12321). Nota: No podemos
transformar el numero a cadena para realizar el ejercicio.
*/
fun esCapicua () {
    val input= readLine()!!
    var count = 0

    if (isNumber(input)) {
        // Se determina el tamaño del número
        var numTamanio = input.toInt()
        while (numTamanio != 0) {
            count += 1
            numTamanio = numTamanio.div(10)
        }
        // Se obtiene numDecimales para realizar operaciones utilizando count
        var numInicial = input.toInt()
        var numDecimales = 1
        var reversoNumero = 0
        for (i in 1 until count) {
            numDecimales *= 10
        }
        // Reverso del número
        while (numDecimales!= 0) {
            // Se selecciona el último número de numInicial
            val numIzquierda = numInicial % 10
            //Se quita el último número a numInicial
            numInicial = numInicial.div(10)
            // Se obtiene el reverso del número
            reversoNumero += (numIzquierda * numDecimales)
            // Se baja ceros a numDecimales
            numDecimales = numDecimales.div(10)
        }
        // Se imprime resultado
        if (reversoNumero == input.toInt()) {
            println("El número ingresado es capicúa")
        } else {
            println("El número no es capicúa")
        }
    }  else {
        println("Valor no válido")
    }
}
/*
Crea un programa que dibuje un triángulo equilátero con asteriscos "*".
*/
fun dibujarTriangulo () {
    val input= readLine()!!

    if (isNumber(input)) {
        var tamanioPoligono = input.toInt()

        // Se tranforma el tamaño a un numero impar
        if (tamanioPoligono % 2 == 0) {
            tamanioPoligono += 1
        }
        // Factores para construir el triángulo
        val centroTriangulo = ((tamanioPoligono - 1) / 2) + 1
        var numeroSignos = 1
        var numeroEspacioIzquierda = (tamanioPoligono - 1) / 2
        var numeroEspacioDerecha = (tamanioPoligono - 1) / 2

        // Construción del triángulo
        for (i in 1..centroTriangulo) {
            // Imprimir figura
            print(" ". repeat(numeroEspacioIzquierda))
            print("*".repeat(numeroSignos))
            print(" ". repeat(numeroEspacioDerecha))

            // Salto linea
            println()

            // Configuración numero de impresiones
            numeroEspacioIzquierda -= 1
            numeroEspacioDerecha -= 1
            numeroSignos += 2
        }
    } else {
        println("Valor no válido")
    }
}

/*
Enunciado: Crea una función que evalúe si un/a atleta ha superado correctamente una
carrera de obstáculos.
- La función recibirá dos parámetros:
- Un array que sólo puede contener String con las palabras "run" o "jump"
- Un String que represente la pista y sólo puede contener "_" (suelo) o "|" (valla)
- La función imprimirá cómo ha finalizado la carrera:
- Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla) será correcto y no
variará el símbolo de esa parte de la pista.
- Si hace "jump" en "_" (suelo), se variará la pista por "x".
- Si hace "run" en "|" (valla), se variará la pista por "/".
- La función retornará una frase que indique si ha superado la carrera.
Para ello tiene que realizar la opción correcta en cada tramo de la pista.
*/
fun carreraObstaculos () {
    println("Ingrese RUN o JUMP separados de un espacio:")
    val datos1 = readLine()!!.split(" ").map { it }.toMutableList()
    println("Ingrese _ o | separados de un espacio:")
    val datos2 = readLine()!!.split(" ").map { it }.toMutableList()

    if (datos1.size == datos2.size) {
        val regexSignos = Regex("""[^\|_]""")
        var verificarEntrada = true

        // Se intercambia valores por / y X
        for (i in datos1.indices) {
            when {
                datos1[i].lowercase() == "run" && datos2[i] == "|" -> datos2[i] = "/"
                datos1[i].lowercase() == "jump" && datos2[i] == "_" -> datos2[i] = "X"
            }
        }
        // Se verifica contenido de los datos ingresados
        datos2.forEach {
            if (regexSignos.containsMatchIn(it) || datos1.contains("_") || datos1.contains("|")){
                verificarEntrada = false
            }
        }
        // Se imprime resultado
        if (!datos2.contains("X") && !datos2.contains("/") && verificarEntrada) {
            println("Carrera superada.")
        } else {
            println("Carrera no superada.")
        }
        println(datos2.joinToString(""))
    } else {
        println("Ingreso de datos incorrecto.")
    }
}
/*
 Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
*/
fun separacionElementos () {
    println("Ingrese elementos del conjunto 1 separados por un espacio: ")
    val elementos1 = readLine()!!.split(" ").map { it }.toMutableList()
    println("Ingrese elementos del conjunto 2 separados por un espacio: ")
    val elementos2 = readLine()!!.split(" ").map { it }.toMutableList()
    println("Ingrese true o false: ")
    val comunes = readLine()!!
    val elementosSeleccionados = mutableSetOf<String>()
    val elementosNoSeleccionados = mutableSetOf<String>()

    elementos1.forEach {
        if (elementos2.contains(it) && comunes == "true") {
            elementosSeleccionados.add(it)
        } else if (!elementos2.contains(it) && comunes == "false") {
            elementosNoSeleccionados.add(it)
        }
    }
    elementos2.forEach {
        if (elementos1.contains(it) && comunes == "true") {
            elementosSeleccionados.add(it)
        } else if (!elementos1.contains(it) && comunes == "false") {
            elementosNoSeleccionados.add(it)
        }
    }
    when (comunes) {
        "true" -> println("Elementos comunes: $elementosSeleccionados")
        "false" -> println("Elementos no comunes: $elementosNoSeleccionados")
        else -> println("Debe ingresar datos válidos")
    }
}
/*
Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
poner en mayúscula la primera letra de cada palabra.
- No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
*/
fun  mayusculaPrimeraLetra () {
    println("Ingrese la oración: ")
    val text = readLine()!!
    var textMayuscula = text
    val regexSignos = Regex("""[ .,!¡¿?:;]""")
    val textSinSignos =  text.replace(regexSignos, " ")

    // A textMayuscula que es igual al texto inicial se le remplaza la palabra proporcionada por textSinSignos
    textSinSignos.split(" ").forEach { word ->
        textMayuscula = textMayuscula.replace(word, word.replaceFirstChar { it.uppercase() })
    }
    println(textMayuscula)
}
/*
Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 - La función recibirá dos String y retornará un Int.
 - La diferencia en días será absoluta (no importa el orden de las fechas).
 - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
*/
fun calcularDias (){
    println("Ingrese la fecha 1 (20-01-2022)")
    val fecha1 = readLine()!!
    println("Ingrese la fecha 2 (20-01-2022)")
    val fecha2 = readLine()!!
    try {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val date1 = dateFormat.parse(fecha1)
        val date2 = dateFormat.parse(fecha2)
        val diferenciaFechas = date1?.time!! - date2?.time!!
        val segundos: Long = diferenciaFechas / 1000
        val minutos: Long = segundos / 60
        val horas: Long = minutos / 60
        val dias: Long = horas / 24
        println("${dias.absoluteValue} días.")
    } catch (e:Exception) {
        println("Ingrese la fecha de forma adecuada")
    }
}
/* Enunciado: Escribe una función que calcule si un número dado es un número de
Amstrong (o también llamado narcisista). */
fun numeroAmstrong () {
    println("Ingrese un número: ")
    val input1 = readLine()
    var resultado = 0.0

    if (isNumber(input1.toString()) && input1!!.toInt() >= 0) {
        val listNum = mutableListOf<Int>()
        val size = input1.length
        for (i in input1) {
            listNum.add(i.toString().toInt())
        }
        listNum.forEach {
            resultado += it.toDouble().pow(size)
        }
        if (input1.toDouble() == resultado) {
            println("true")
        } else {
            println("false")
        }
    } else {
        println("Ingrese un número válido.")
    }
}
/* Enunciado: Escribe una función que calcule y retorne el factorial de un número dado. */
fun factorialNumero () {
    println("Ingrese un número: ")
    val input1 = readLine().toString()
    var resultado = 1
    var valor = 1
    if (isNumber(input1)) {
        val num = input1.toInt()
        when {
            num < 0 -> println("No tiene factorial")
            num <= 1 -> println("1")
            else -> {
                for (i in 1 until num) {
                    valor += 1
                    resultado *= valor
                }
                println(resultado)
            }
        }
    } else {
        println("Ingrese un número válido.")
    }
}
/* Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean)
según sean o no palíndromos.
 Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 Ejemplo: Ana lleva al oso la avellana. */
fun esUnPolindromo () {
    println("Ingrese las palabras: ")
    var input1 = readLine()!!.lowercase()
    val regexSignos = Regex("""[ .,!¡¿?:;]""")

    input1 = input1.replace(regexSignos, "")
    // Transforma las letras con signos extras como la tilde en la tetra base Ejm: Á = a
    input1 = Normalizer.normalize(input1, Normalizer.Form.NFD).replace("\\p{Mn}+".toRegex(), "")
    val reverso = input1.reversed()

    if (input1 == reverso) {
        println(true)
    } else {
        println(false)
    }
}
/*  * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos
cadenas como salida (out1, out2).
 out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1. */
fun eliminandoCaracteres () {
    println("Ingrese palabras 1: ")
    val input1 = readLine()
    println("Ingrese palabras 2: ")
    val input2 = readLine()
    var out1 = ""
    var out2 = ""
    input1!!.forEach {
        if (!input2!!.contains(it)) {
            out1 += it
        }
    }
    input2!!.forEach {
        if (!input1!!.contains(it)) {
            out2 += it
        }
    }
    println("out1 " + out1)
    println("out2 " + out2)
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
    println("Seleccione la figura geométrica -> 1:Triángulo | 2:Rectángulo | 3:Cuadrado")
    val tipoPoligono = readLine()
    var datos = mutableListOf<String>()

    // Se comprueba tipo de polígono
    when (tipoPoligono) {
        "1" -> {
            println("Ingrese el valor de base y altura separados por un espacio. Ejm. 18 20 ")
            datos = readLine()?.split(" ")?.map { it }?.toMutableList()!!
        }
        "2" -> {
            println("Ingrese el valor de largo y ancho separados por un espacio. Ejm. 18 20 ")
            datos = readLine()?.split(" ")?.map { it }?.toMutableList()!!
        }
        "3" -> {
            println("Ingrese el valor de lado. Ejm. 10: ")
            datos = readLine()?.split(" ")?.map { it }?.toMutableList()!!
        }
        else -> println("Selección incorrecta")
    }

    val sonNumeros = mutableListOf<Boolean>()
    var numOk = false
    //var tipoPoligono = ""

    // Se comprueba que los datos ingresados son números
    for (i in datos) {
        val comprobacion = isNumber(i)
        sonNumeros.add(comprobacion)
    }
    if (!sonNumeros.contains(false)) { numOk = true}

    // Resultados
    when {
        !numOk -> println("Ingrese números")
        tipoPoligono == "1" -> println("El área del triángulo es: ${ AreaTriangulo().resultadoArea(datos)}")
        tipoPoligono == "2" -> println("El área del rectángulo es: ${ AreaRectangulo().resultadoArea(datos)}")
        tipoPoligono == "3" -> println("El área del cuadrado es: ${ AreaCuadrado().resultadoArea(datos)}")
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

