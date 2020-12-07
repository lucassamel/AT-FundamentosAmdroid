package lucassamel.br.at_fundamentosamdroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_filme_recycler.view.*
import lucassamel.br.at_fundamentosamdroid.R
import lucassamel.br.at_fundamentosamdroid.model.Filme

class FilmeRecyclerAdapter(
    private val filmes : List<Filme>,
    private val actionClick : (Filme) -> Unit
)
    : RecyclerView.Adapter<FilmeRecyclerAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {
            val textViewNome = view.textViewRecyclerFilmeNome
            val textViewLancamento = view.textViewRecyclerFilmeLacamento
            val btnShow = view.btnRecyclerFilmeShow


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.list_filme_recycler,
                parent,
                false
            )

        val filmeViewHolder = FilmeViewHolder(view)
        return filmeViewHolder
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes.get(position)
        holder.textViewLancamento.text = filme.anoLancamento
        holder.textViewNome.text = filme.nomeFilme
        holder.btnShow.setOnClickListener {
            actionClick(filme)
        }
    }

    override fun getItemCount(): Int = filmes.size
        //return filmes.size

}