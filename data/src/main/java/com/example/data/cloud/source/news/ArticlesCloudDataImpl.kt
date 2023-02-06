package com.example.data.cloud.source.news

import com.example.data.cloud.api.NewsApi
import com.example.data.cloud.models.NewsCloud
import com.example.data.models.NewsData
import com.example.domain.Mapper
import com.example.domain.helper.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class ArticlesCloudDataImpl(
    private val api: NewsApi,
    private val mapper: Mapper<NewsCloud, NewsData>,
    private val dispatchersProvider: DispatchersProvider
) : ArticlesCloudDataSource {

    override fun getAllArticles(keyword: String, sortBy: String): Flow<NewsData> = flow {
        emit(api.getEverything(keyword = keyword, sortBy = sortBy))
    }.flowOn(dispatchersProvider.io()).map { it.body()!! }.map(mapper::map)
        .flowOn(dispatchersProvider.default())


    override fun getAllTopHeadLines(keyword: String, category: String): Flow<NewsData> = flow {
        emit(api.getTopHeadLines(keyword = keyword, category = category))
    }.flowOn(dispatchersProvider.io()).map { it.body()!! }.map(mapper::map)
        .flowOn(dispatchersProvider.default())

}