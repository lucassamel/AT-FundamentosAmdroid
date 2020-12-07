package lucassamel.br.at_fundamentosamdroid.ui

import androidx.lifecycle.ViewModel
import lucassamel.br.at_fundamentosamdroid.model.Filme

class FilmeViewModel : ViewModel() {
    //Regras de Negocio

    fun salvarFilme(
        nomeFilme: String,
        anoLancamento: String
    ): Boolean {
        var filme = Filme(nomeFilme, anoLancamento)
        filme.store()
        return true
    }
}