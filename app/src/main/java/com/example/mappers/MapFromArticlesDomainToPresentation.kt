package com.example.mappers

import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.models.ArticlesPresentation

class MapFromArticlesDomainToPresentation :
    Mapper<ArticlesDomain, ArticlesPresentation> {
        override fun map(from: ArticlesDomain) = from.run {
            ArticlesPresentation(
                title = title,
                description = description,
                url = url,
                urlToImage = urlToImage,
                publishedAt = publishedAt
            )
        }
    }