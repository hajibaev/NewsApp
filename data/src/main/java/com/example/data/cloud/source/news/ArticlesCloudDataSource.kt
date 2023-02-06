package com.example.data.cloud.source.news

import com.example.data.models.NewsData
import kotlinx.coroutines.flow.Flow

interface ArticlesCloudDataSource {
    fun getAllArticles(keyword: String, sortBy: String): Flow<NewsData>
    fun getAllTopHeadLines(keyword: String, category: String): Flow<NewsData>
}