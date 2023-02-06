package com.example.mappers

import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.models.ArticlesPresentation

class SaveMap : Mapper<ArticlesPresentation, ArticlesDomain> {
    override fun map(from: ArticlesPresentation) = from.run {
        ArticlesDomain(
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}