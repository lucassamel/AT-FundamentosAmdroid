package lucassamel.br.at_fundamentosamdroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_lista_filme.*
import lucassamel.br.at_fundamentosamdroid.FullViewModel
import lucassamel.br.at_fundamentosamdroid.R

class ListaFilmeFragment : Fragment() {

    private lateinit var listFilmeViewModel: FilmeViewModel
    private lateinit var fullViewModel: FullViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_filme, container, false)

        fullViewModel =
            ViewModelProvider(requireActivity())
                .get(FullViewModel::class.java)

        listFilmeViewModel = ViewModelProvider(this).get(FilmeViewModel::class.java)

        listFilmeViewModel
            .status
            .observe(viewLifecycleOwner) {
                // if (it)

            }

        listFilmeViewModel
            .msg
            .observe(viewLifecycleOwner) {
                showSnackbar(it)
            }

        listFilmeViewModel
            .filmes
            .observe(viewLifecycleOwner) {
                listViewFilmes
                    .adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    it
                )
            }

        return view
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(
            list_filme_layout_root,
            msg,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewFilmes.setOnItemClickListener  { adapterView, view, i, l ->
            val listaFilmes = listFilmeViewModel.filmes.value!!
            val filme = listaFilmes.get(i)
            fullViewModel.selectFilme(filme)
            //showSnackbar((filme.toString())

            findNavController().navigate(R.id.showFilmeFragment)

        }
    }


}


