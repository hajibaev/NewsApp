package com.example.data.data.internet.mappers.news

import com.example.data.cloud.models.ArticlesCloud
import com.example.data.models.ArticlesData
import com.example.domain.Mapper

class MapFromArticlesCloudListToData(private val mapper: Mapper<ArticlesCloud, ArticlesData>) :
        Mapper<List<ArticlesCloud>, List<ArticlesData>> {
    override fun map(from: List<ArticlesCloud>) = from.run {
        this.map { articlesCloud ->
            mapper.map(articlesCloud)
        }
    }
}