package lucassamel.br.at_fundamentosamdroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_cadastrar_filme.*
import lucassamel.br.at_fundamentosamdroid.R
import lucassamel.br.at_fundamentosamdroid.model.Filme

class CadastrarFilmeFragment : Fragment() {

    private lateinit var filmeViewModel: FilmeViewModel

    var quantidadeFilmes = MutableLiveData<Int>()

    init {
        quantidadeFilmes.value = 2
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_cadastrar_filme, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmeViewModel =
            ViewModelProvider(this, FilmeViewModelFactory()).get(FilmeViewModel::class.java)

        filmeViewModel.quantidadeFilme
            .observe(viewLifecycleOwner,
                {
                    textViewTotalFilmes.text = it.toString()
                })

        btnCadastrarFilme.setOnClickListener {
            var nomeFilme = editTextNomeFilme.text.toString()
            var anoLancamento = editTextAnoFilme.text.toString()

            //var filme = Filme(nomeFilme, anoLancamento)
            // filme.store()

            if (!nomeFilme.isNullOrEmpty() && !anoLancamento.isNullOrEmpty()) {
                filmeViewModel.salvarFilme(nomeFilme, anoLancamento)
                filmeViewModel.addFilme()

                Toast.makeText(
                    requireContext(),
                    "Filme Cadastrado com Sucesso!",
                    Toast.LENGTH_LONG
                ).show()

                quantidadeFilmes.value!!.plus(1)

                findNavController().navigate(R.id.action_cadastrarFilmeFragment_to_listaFilmeFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Preencha todos os campos",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    }

}