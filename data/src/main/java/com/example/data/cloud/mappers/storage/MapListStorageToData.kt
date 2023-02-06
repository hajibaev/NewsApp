package com.example.data.data.internet.mappers.storage

import com.example.data.models.ArticlesData
import com.example.data.storage.models.StorageModels
import com.example.domain.Mapper

class MapListStorageToData(private val mapper: Mapper<StorageModels, ArticlesData>) :
    Mapper<List<StorageModels>, List<ArticlesData>> {
    override fun map(from: List<StorageModels>) = from.map {
        mapper.map(it)
    }
}