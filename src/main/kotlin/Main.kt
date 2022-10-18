fun main(args: Array<String>) {
    //Reto número 0
    //fizzBuzz()
    //Reto número 1
    //isAnagrama("amor", "romA")
    //Reto número 2
    fibonacci()

    println()
    val list = listOf(89, 144, 233, 377, 610, 987, 1597)
    println(list.sortedDescending())

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