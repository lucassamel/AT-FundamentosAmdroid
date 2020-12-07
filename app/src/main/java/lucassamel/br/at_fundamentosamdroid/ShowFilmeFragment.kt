package lucassamel.br.at_fundamentosamdroid

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.show_filme_fragment.*
import lucassamel.br.at_fundamentosamdroid.model.Filme

class ShowFilmeFragment : Fragment() {

    //private lateinit var viewModel: ShowFilmeViewModel
    private lateinit var fullViewModel: FullViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.show_filme_fragment, container, false)

        fullViewModel =
            ViewModelProvider(requireActivity())
                .get(FullViewModel::class.java)

        fullViewModel.filme
            .observe(viewLifecycleOwner){
                updateUI(it)
            }

        return view
    }

    private fun updateUI(filme: Filme) {
        textViewNomeFilme.text = filme.nomeFilme
        textViewAnoLancamento.text = filme.anoLancamento
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ShowFilmeViewModel::class.java)
//
//    }

}