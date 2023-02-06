package com.example.data.cloud.source.storage

import com.example.data.models.ArticlesData
import com.example.data.storage.models.StorageModels
import com.example.data.storage.room.NewsDao
import com.example.domain.Mapper
import com.example.domain.helper.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


class CloudDataSourceForStorageImpl(
    private val dao: NewsDao,
    private val mapper: Mapper<ArticlesData, StorageModels>,
    private val mapList: Mapper<List<StorageModels>, List<ArticlesData>>,
    private val dispatchersProvider: DispatchersProvider
) : CloudDataSourceForStorage {
    override suspend fun saveNews(news: ArticlesData) =
        withContext(dispatchersProvider.io()) {
            dao.saveMovie(storage = mapper.map(news))
        }

    override suspend fun deleteNews(url: String) {
        withContext(dispatchersProvider.io()) {
            dao.deleteMovieFromSaveStorage(url = url)
        }
    }

    override fun getStorageMovies(): Flow<List<ArticlesData>> =
        dao.getStorageMovies()
            .flowOn(dispatchersProvider.io())
            .map(mapList::map)
            .flowOn(dispatchersProvider.default())
}