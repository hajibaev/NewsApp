package com.example.data.data.internet.mappers.storage

import com.example.data.models.ArticlesData
import com.example.data.storage.models.StorageModels
import com.example.domain.Mapper

class MapStorageToData : Mapper<StorageModels, ArticlesData> {
    override fun map(from: StorageModels) = from.run {
        ArticlesData(
            url = url,
            title = title,
            description = description,
            urlToImage = urlToImage,
            publishedAt = publishedAt
        )
    }
}