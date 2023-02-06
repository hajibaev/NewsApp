package com.example.data.cloud.source.storage

import com.example.data.models.ArticlesData
import kotlinx.coroutines.flow.Flow

interface CloudDataSourceForStorage {
    suspend fun saveNews(news: ArticlesData)
    suspend fun deleteNews(url: String)
    fun getStorageMovies(): Flow<List<ArticlesData>>
}