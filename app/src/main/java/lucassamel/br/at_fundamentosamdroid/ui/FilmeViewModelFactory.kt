package lucassamel.br.at_fundamentosamdroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FilmeViewModelFactory : ViewModelProvider.Factory {
//Interface
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FilmeViewModel::class.java))
            return FilmeViewModel() as T
        throw IllegalArgumentException("Classe ViewModel deve ser FilmeViewModel")
    }


}