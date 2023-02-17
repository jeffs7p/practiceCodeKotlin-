package retos


/*
Reto 2: ¡Atrapa a esos ciber criminales!

Problema

Un grupo de ciber criminales están usando mensajes encriptados para comunicarse. El FBI nos ha pedido ayuda para descifrarlos.

Los mensajes son cadenas de texto que incluyen números enteros muy largos y espacios en blanco. Aunque los números no parecen tener sentido... una chica llamada Alice ha descubierto que podrían usar el código ASCII de las letras en minúscula.

Con su método ha conseguido descifrar estos mensajes:

"109105100117" -> midu
"9911110010110998101114" -> codember
"9911110010110998101114 109105100117" -> codember midu
"11210897121 116101116114105115" -> play tetris
Pero han interceptado un mensaje más largo que no han podido y nos han dicho que es muy importante que lo descifremos:

11610497110107115 102111114 11210897121105110103 9911110010110998101114 11210810197115101 11510497114101

Ahora que ya sabes esto, https://codember.dev/encrypted.txt

Pistas
Recuerda que los mensajes son cadenas de texto conformadas por números y espacios en blanco.
Parece que los números tienen algo que ver con el código ASCII.
Los espacios en blanco parece que son simplemente espacios...
 */
fun main () {
    descifrarMensajes()
}

fun descifrarMensajes () {
    var codigoAdescifrar = "11610497110107115 102111114 11210897121105110103 9911110010110998101114 11210810197115101 11510497114101"

    val regexA = Regex("""97""")
    val regexB = Regex("""98""")
    val regexC = Regex("""99""")
    val regexD = Regex("""100""")
    val regexE = Regex("""101""")
    val regexF = Regex("""102""")
    val regexG = Regex("""103""")
    val regexH = Regex("""104""")
    val regexI = Regex("""105""")
    val regexJ = Regex("""106""")
    val regexK = Regex("""107""")
    val regexL = Regex("""108""")
    val regexM = Regex("""109""")
    val regexN = Regex("""110""")
    val regexO = Regex("""111""")
    val regexP = Regex("""112""")
    val regexQ = Regex("""113""")
    val regexR = Regex("""114""")
    val regexS = Regex("""115""")
    val regexT = Regex("""116""")
    val regexU = Regex("""117""")
    val regexV = Regex("""118""")
    val regexW = Regex("""119""")
    val regexX = Regex("""120""")
    val regexY = Regex("""121""")
    val regexZ = Regex("""122""")
    val regexEspacio = Regex(""" """)

    codigoAdescifrar = regexK.replace(codigoAdescifrar, "k")
    codigoAdescifrar = regexS.replace(codigoAdescifrar, "s")
    codigoAdescifrar = regexA.replace(codigoAdescifrar, "a")
    codigoAdescifrar = regexB.replace(codigoAdescifrar, "b")
    codigoAdescifrar = regexC.replace(codigoAdescifrar, "c")
    codigoAdescifrar = regexD.replace(codigoAdescifrar, "d")
    codigoAdescifrar = regexF.replace(codigoAdescifrar, "f")
    codigoAdescifrar = regexG.replace(codigoAdescifrar, "g")
    codigoAdescifrar = regexH.replace(codigoAdescifrar, "h")
    codigoAdescifrar = regexI.replace(codigoAdescifrar, "i")
    codigoAdescifrar = regexJ.replace(codigoAdescifrar, "j")
    codigoAdescifrar = regexL.replace(codigoAdescifrar, "l")
    codigoAdescifrar = regexM.replace(codigoAdescifrar, "m")
    codigoAdescifrar = regexN.replace(codigoAdescifrar, "n")
    codigoAdescifrar = regexP.replace(codigoAdescifrar, "p")
    codigoAdescifrar = regexQ.replace(codigoAdescifrar, "q")
    codigoAdescifrar = regexR.replace(codigoAdescifrar, "r")
    codigoAdescifrar = regexT.replace(codigoAdescifrar, "t")
    codigoAdescifrar = regexU.replace(codigoAdescifrar, "u")
    codigoAdescifrar = regexV.replace(codigoAdescifrar, "v")
    codigoAdescifrar = regexW.replace(codigoAdescifrar, "w")
    codigoAdescifrar = regexX.replace(codigoAdescifrar, "x")
    codigoAdescifrar = regexY.replace(codigoAdescifrar, "y")
    codigoAdescifrar = regexZ.replace(codigoAdescifrar, "z")
    codigoAdescifrar = regexE.replace(codigoAdescifrar, "e")
    codigoAdescifrar = regexO.replace(codigoAdescifrar, "o")
    codigoAdescifrar = regexEspacio.replace(codigoAdescifrar, " ")

    println(codigoAdescifrar)
}
