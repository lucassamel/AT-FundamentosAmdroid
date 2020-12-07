package lucassamel.br.at_fundamentosamdroid.ui

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.at_fundamentosamdroid.database.AppDatabase
import lucassamel.br.at_fundamentosamdroid.model.Filme

class FilmeViewModel : ViewModel() {
    //Regras de Negocio

    private val _filmes = MutableLiveData<List<Filme>>()
    val filmes: LiveData<List<Filme>>
        get() = _filmes

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean>
        get() = _status

    private val _msg = MutableLiveData<String>()
    val msg : LiveData<String>
        get() = _msg

    init {
        _status.value = false
        _msg.value = null
        getAll()
    }

    fun getAll(){
        val appDatabase = AppDatabase.getInstance()
        _filmes.value = appDatabase.all()
    }
    fun salvarFilme(
        nomeFilme: String,
        anoLancamento: String
    ): Boolean {
        var filme = Filme(nomeFilme, anoLancamento)
        filme.store()
        return true
    }
}