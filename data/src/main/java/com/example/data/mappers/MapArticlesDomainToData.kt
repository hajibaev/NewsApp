package com.example.data.mappers

import com.example.data.models.ArticlesData
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain

class MapArticlesDomainToData :
    Mapper<ArticlesDomain, ArticlesData> {
    override fun map(from: ArticlesDomain) = from.run {
        ArticlesData(
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}