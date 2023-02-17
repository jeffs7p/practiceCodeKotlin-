package retos

/*
    CATEGORIAS:
    "MOTIVACIÓN Y LIDERAZGO"
    "EMPRENDIMIENTO"
    "REFRANES"
    "FRASES INGRESADAS Y FAVORITOS"
    "ADMINISTRACIÓN DE EMPRESAS"
    "COMICS, ANIME Y PELÍCULAS"
    "CRISTIANAS"
 */

fun main () {
    val insertarTextosEnList = InsertarTextosEnList()

    insertarTextosEnList.listafrasesInternaTexto()
}


class InsertarTextosEnList() {

    fun listafrasesInternaTexto() {

        val listaAingresar = mutableListOf(
           "El germen de todo plan y de toda empresa es una idea; no capital, ni trabajo, sino una idea. Henry Ford",
"Cuando las órdenes son razonables, justas, sencillas, claras y consecuentes, existe una satisfacción recíproca entre el líder y el grupo. Sun Tzu",
"Si quieres persuadir a alguien, utiliza sus mismos argumentos. Aristóteles",
            "Trata a un hombre tal como es, y seguirá siendo lo que es; trátalo como puede y debe ser, y se convertirá en lo que puede y debe ser. Johann Wolfgang",
"Mis cinco nuncas: Nunca aparentar, nunca mantenerse inmóvil, nunca aferrarse al pasado, nunca darse por vencido, nunca dejar de soñar. Steve Jobs",
"Un hombre inteligente es aquel que sabe ser tan inteligente como para contratar gente más inteligente que él. John F. Kenedy",
"Lo correcto es correcto aunque todos lo condenen, lo incorrecto es incorrecto aunque todos lo aprueben. Charles Spurgeon",
        )
        val sizeListaIngresar = listaAingresar.size

        val listaFrases = mutableListOf<ListaFrasesInterna> ()

        for (i in 0 until sizeListaIngresar) {
            listaFrases.add(ListaFrasesInterna(listaAingresar[i], "ADMINISTRACIÓN DE EMPRESAS"))
        }

        //ListaFrasesInterna("Frase", "TODAS LAS FRASES")
        listaFrases.forEach {
            println("ListaFrasesInterna(\"${it.fraseInterna}\", \" ${it.clasificacionInterna}\"),")
        }

    }
}

data class ListaFrasesInterna(
    val fraseInterna: String,
    val clasificacionInterna: String
)