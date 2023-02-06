package com.example.data.mappers

import com.example.data.models.ArticlesData
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain

class MapArticlesDataFromToDomain :
    Mapper<ArticlesData, ArticlesDomain> {
    override fun map(from: ArticlesData) = from.run {
        ArticlesDomain(
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}