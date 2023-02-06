package com.example.data.data.internet.mappers.storage

import com.example.data.models.ArticlesData
import com.example.data.storage.models.StorageModels
import com.example.domain.Mapper

class MapArticlesDataToStorage : Mapper<ArticlesData, StorageModels> {
    override fun map(from: ArticlesData) = from.run {
        StorageModels(
            url = url,
            title = title,
            description = description,
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}