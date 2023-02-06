package com.example.data.data.storage.mappers

import com.example.data.storage.models.StorageModels
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain

class MapFromDomainSourceToData :
    Mapper<ArticlesDomain, StorageModels> {
    override fun map(from: ArticlesDomain) = from.run {
        StorageModels(
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}