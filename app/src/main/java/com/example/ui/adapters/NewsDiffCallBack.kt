package com.example.ui.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.models.ArticlesPresentation

class NewsDiffCallBack : DiffUtil.ItemCallback<ArticlesPresentation>() {
    override fun areItemsTheSame(
        oldItem: ArticlesPresentation,
        newItem: ArticlesPresentation
    ): Boolean {
        return oldItem.urlToImage == newItem.urlToImage
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: ArticlesPresentation,
        newItem: ArticlesPresentation
    ): Boolean {
        return oldItem == newItem
    }
}
