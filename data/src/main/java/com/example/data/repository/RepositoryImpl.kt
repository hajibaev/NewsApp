package com.example.data.repository

import com.example.data.cloud.source.news.ArticlesCloudDataSource
import com.example.data.models.NewsData
import com.example.domain.Mapper
import com.example.domain.helper.DispatchersProvider
import com.example.domain.models.NewsDomain
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class RepositoryImpl(
    private val articlesCloudData: ArticlesCloudDataSource,
    private val mapper: Mapper<NewsData, NewsDomain>,
    private val dispatchersProvider: DispatchersProvider
) : Repository {
    override fun getEverything(query: String, sortBy: String): Flow<NewsDomain> =
        articlesCloudData.getAllArticles(keyword = query, sortBy = sortBy)
            .map(mapper::map)
            .flowOn(dispatchersProvider.default())

    override fun getTopHeadLines(query: String, category: String): Flow<NewsDomain> =
        articlesCloudData.getAllTopHeadLines(keyword = query, category = category)
            .map(mapper::map)
            .flowOn(dispatchersProvider.default())
}