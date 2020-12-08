package lucassamel.br.at_fundamentosamdroid.ui

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lucassamel.br.at_fundamentosamdroid.database.AppDatabase
import lucassamel.br.at_fundamentosamdroid.model.Filme

class FilmeViewModel : ViewModel() {
    //Regras de Negocio

    var quantidadeFilme = MutableLiveData<Int>()
    init {
        quantidadeFilme.value = 2
    }

    fun addFilme(){
        quantidadeFilme.value = quantidadeFilme.value!!
            .plus(1)
    }

    private val _filmes = MutableLiveData<List<Filme>>()
    val filmes: LiveData<List<Filme>>
        get() = _filmes

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean>
        get() = _status

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    init {
        _status.value = false
        _msg.value = null
        getAll()
    }

    fun getAll() {
        _msg.value = "Consultando a base de dados."
        val appDatabase = AppDatabase.getInstance()
        _filmes.value = appDatabase.all()

        if (true) {
            _status.value = true
            _msg.value = "Consulta ralizada com sucesso!"
        }
    }

    fun salvarFilme(
        nomeFilme: String,
        anoLancamento: String
    ) {
        var filme = Filme(nomeFilme, anoLancamento)
        AppDatabase.getInstance().store(filme)
    }
}