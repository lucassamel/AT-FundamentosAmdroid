package lucassamel.br.at_fundamentosamdroid.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.at_fundamentosamdroid.model.Filme

class FilmeViewModel : ViewModel() {
    //Regras de Negocio

    var quantidadeFilmes = MutableLiveData<Filme>()

    fun salvarFilme(
        nomeFilme: String,
        anoLancamento: String
    ): Boolean {
        var filme = Filme(nomeFilme, anoLancamento)
        filme.store()
        return true
    }
}