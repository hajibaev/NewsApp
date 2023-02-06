package com.example.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.R
import com.example.models.ArticlesPresentation


class NewsAdapter(private val listener: RecyclerOnClickListener) :
    ListAdapter<ArticlesPresentation, NewsViewHolder>(NewsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            listener.onItem(getItem(position).url.toString())
        }
        holder.itemView.setOnLongClickListener {
            listener.onLongItem(getItem(position))
            true
        }
    }

    interface RecyclerOnClickListener {
        fun onItem(url: String)
        fun onLongItem(articlesPresentation: ArticlesPresentation)
    }
}


