package lucassamel.br.at_fundamentosamdroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_cadastrar_filme.*
import lucassamel.br.at_fundamentosamdroid.R
import lucassamel.br.at_fundamentosamdroid.model.Filme

class CadastrarFilmeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar_filme, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCadastrarFilme.setOnClickListener {
            var nomeFilme = editTextNomeFilme.text.toString()
            var anoLancamento = editTextAnoFilme.text.toString()

            var filme = Filme(nomeFilme, anoLancamento)
            filme.store()
            Toast.makeText(
                requireContext(),
                "Filme Cadastrado com Sucesso!",
                Toast.LENGTH_LONG
            ).show()

        }

    }

}