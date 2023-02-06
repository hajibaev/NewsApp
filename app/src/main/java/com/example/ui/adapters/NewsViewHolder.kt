package com.example.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.models.ArticlesPresentation
import com.squareup.picasso.Picasso

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val newsImage: ImageView = view.findViewById(R.id.news_ima)
    private val newsDate: TextView = view.findViewById(R.id.news_data)
    private val newsTitle: TextView = view.findViewById(R.id.news_title)

    fun bind(articles: ArticlesPresentation) {
        if (articles.urlToImage != null) {
            Picasso.get().load(articles.urlToImage).into(newsImage)
        }
        itemView.setOnClickListener {

        }
        newsDate.text = articles.publishedAt
        newsTitle.text = articles.title
    }
}