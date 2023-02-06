package com.example.data.data.internet.mappers.news

import com.example.data.cloud.models.ArticlesCloud
import com.example.data.cloud.models.NewsCloud
import com.example.data.models.ArticlesData
import com.example.data.models.NewsData
import com.example.domain.Mapper

class MapFromNewsCloudToData(private val mapper: Mapper<List<ArticlesCloud>, List<ArticlesData>>) :
    Mapper<NewsCloud, NewsData> {
    override fun map(from: NewsCloud) = from.run {
        NewsData(
            articles = mapper.map(articles)
        )
    }
}