package com.example.data.repository

import com.example.data.cloud.source.storage.CloudDataSourceForStorage
import com.example.data.models.ArticlesData
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StorageRepositoryImpl(
    private val datasource: CloudDataSourceForStorage,
    private val mapper: Mapper<ArticlesDomain, ArticlesData>,
    private val mapList: Mapper<List<ArticlesData>, List<ArticlesDomain>>
) : StorageRepository {

    override suspend fun saveNews(news: ArticlesDomain) =
        datasource.saveNews(news = mapper.map(news))


    override suspend fun deleteNews(url: String) =
        datasource.deleteNews(url)


    override fun getStorageMovies(): Flow<List<ArticlesDomain>> =
        datasource.getStorageMovies().map(mapList::map)
}