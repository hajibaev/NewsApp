package com.example.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.databinding.StorageItemBinding
import com.example.models.ArticlesPresentation
import com.squareup.picasso.Picasso

class NewsStorageAdapter(
    private val favMovieEntityList: List<ArticlesPresentation>,
    private val listener: RecyclerFavOnClickListener
) : ListAdapter<ArticlesPresentation, NewsStorageAdapter.ViewHolder>(NewsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.storage_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favMovieEntityList[position])

        holder.itemView.setOnClickListener {
            listener.onClearItemClick(position)
        }
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
        holder.itemView.startAnimation(
            AnimationUtils.loadAnimation
                (holder.itemView.context, R.anim.animationrv)
        )
    }

    override fun getItemCount(): Int {
        return favMovieEntityList.size
    }

    interface RecyclerFavOnClickListener {
        fun onItemClick(position: Int)
        fun onClearItemClick(position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = StorageItemBinding.bind(itemView)
        fun bind(article: ArticlesPresentation) = article.apply {
            with(binding) {
                Picasso.get().load(article.urlToImage).into(saveItemImage)
                title.text = article.title
                ivDelete.setOnClickListener {
                    listener.onClearItemClick(adapterPosition)
                }
                cvMovie.setOnClickListener {
                    listener.onItemClick(adapterPosition)
                }
            }
        }
    }
}