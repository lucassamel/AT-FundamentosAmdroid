package lucassamel.br.at_fundamentosamdroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.at_fundamentosamdroid.model.Filme

class FullViewModel : ViewModel() {



    private val _filme = MutableLiveData<Filme>()

    val filme: LiveData<Filme>
        get() = _filme

    fun selectFilme(filme: Filme){
    _filme.value = filme
    }
}