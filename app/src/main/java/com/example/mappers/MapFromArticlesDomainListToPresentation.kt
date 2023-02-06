package com.example.mappers

import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.models.ArticlesPresentation

class MapFromArticlesDomainListToPresentation(private val mapper: Mapper<ArticlesDomain, ArticlesPresentation>) :
    Mapper<List<ArticlesDomain>, List<ArticlesPresentation>> {
    override fun map(from: List<ArticlesDomain>) = from.map {
        mapper.map(it)
    }
}
