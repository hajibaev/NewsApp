package com.example.data.data.internet.mappers.news

import com.example.data.cloud.models.ArticlesCloud
import com.example.data.models.ArticlesData
import com.example.domain.Mapper

class MapFromArticlesCloudToData :
    Mapper<ArticlesCloud, ArticlesData> {
    override fun map(from: ArticlesCloud) = from.run {
        ArticlesData(
            title = title,
            description = description,
            url = url,
            urlToImage = urlImage,
            publishedAt = publishedAt
        )
    }
}