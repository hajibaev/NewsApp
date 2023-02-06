package com.example.domain.repository

import com.example.domain.models.ArticlesDomain
import kotlinx.coroutines.flow.Flow


interface StorageRepository {
    suspend fun saveNews(news: ArticlesDomain)

    suspend fun deleteNews(url: String)

    fun getStorageMovies(): Flow<List<ArticlesDomain>>
}