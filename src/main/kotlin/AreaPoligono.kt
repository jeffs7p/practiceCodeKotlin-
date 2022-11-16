interface AreaGeneral {
    fun resultadoArea (dato: MutableList<String>): Double {
        val base = dato[0].toDouble()
        val altura = dato[1].toDouble()
        return (base * altura) / 2
    }
}
class AreaTriangulo (): AreaGeneral {
    override fun resultadoArea(dato: MutableList<String>): Double {
        return super.resultadoArea(dato)
    }
}
class AreaRectangulo (): AreaGeneral {
    override fun resultadoArea(dato: MutableList<String>): Double {
        val largo = dato[0].toDouble()
        val ancho = dato[1].toDouble()
        return largo * ancho
    }
}
class AreaCuadrado (): AreaGeneral {
    override fun resultadoArea(dato: MutableList<String>): Double {
        val lado = dato[0].toDouble()
        return lado * lado
    }
}