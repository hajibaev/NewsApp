package com.example.data.data.storage.mappers

import com.example.data.storage.models.StorageModels
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain

class MapFromDomainToStorageData :
    Mapper<StorageModels, ArticlesDomain> {
    override fun map(from: StorageModels) = from.run {
        ArticlesDomain(
            title = title,
            description = description,
            url = url ?: "",
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}