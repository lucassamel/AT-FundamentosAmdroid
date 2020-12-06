package lucassamel.br.at_fundamentosamdroid.model

class Filme (
    var nomeFilme : String,
    var anoLancamento : Int
        ){
    override fun toString(): String {
        return "$nomeFilme , $anoLancamento"
    }
}