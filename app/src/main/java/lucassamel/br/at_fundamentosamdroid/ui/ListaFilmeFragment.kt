package lucassamel.br.at_fundamentosamdroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import lucassamel.br.at_fundamentosamdroid.R

class ListaFilmeFragment : Fragment() {

    private lateinit var listFilmeViewModel: FilmeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_filme, container, false)

        listFilmeViewModel = ViewModelProvider(this).get(FilmeViewModel::class.java)

        return view

    }


}