package br.com.igorbag.githubsearch.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity

class RepositoryAdapter(private val repositories: List<Repository>, private val main: MainActivity) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    var carItemLister: (Repository) -> Unit = {}
    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //@TODO 8 -  Realizar o bind do viewHolder
        //Exemplo de Bind
        holder.textView.text = repositories[position].name
        holder.btnShare.setOnClickListener {
              Log.d("IMAGEVIEW", "CLICOU NO SHARE")
            main.shareRepositoryLink(repositories[position].htmlUrl)
          }
        holder.cardRepo.setOnClickListener {
            Log.d("CARDVIEW", "${repositories[position].name} - ${position}")
            main.openBrowser(repositories[position].htmlUrl)
        }

        // Exemplo de click no item
        //holder.itemView.setOnClickListener {
        // carItemLister(repositores[position])
        //}

        // Exemplo de click no btn Share
        //holder.favorito.setOnClickListener {
        //    btnShareLister(repositores[position])
        //}
    }

    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
        val textView: TextView
        val btnShare: ImageView
        val cardRepo: CardView

        init {
            view.apply {
                textView = findViewById(R.id.tv_repositorio)
                btnShare = findViewById(R.id.iv_share)
                cardRepo = findViewById(R.id.cv_car)
            }
        }
    }
}


