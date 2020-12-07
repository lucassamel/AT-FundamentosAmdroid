package lucassamel.br.at_fundamentosamdroid.model

import android.util.Log
import kotlin.math.log

class Filme(
    var nomeFilme: String,
    var anoLancamento: String
) {
    override fun toString(): String {
        return "$nomeFilme , $anoLancamento"
    }

    fun store() {
        Log.i("Filme",
            "$nomeFilme registrado com sucesso")
    }
}