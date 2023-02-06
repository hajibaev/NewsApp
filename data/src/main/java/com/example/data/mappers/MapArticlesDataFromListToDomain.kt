package com.example.data.mappers

import com.example.data.models.ArticlesData
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain

class MapArticlesDataFromListToDomain(val mapper: Mapper<ArticlesData, ArticlesDomain>) :
    Mapper<List<ArticlesData>, List<ArticlesDomain>> {
    override fun map(from: List<ArticlesData>) = from.run {
        map { articlesCloud ->
            mapper.map(articlesCloud)
        }
    }
}