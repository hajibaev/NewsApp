package com.example.mappers

import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.domain.models.NewsDomain
import com.example.models.ArticlesPresentation
import com.example.models.NewsPresentation


class MapFromNewsDomainToNewsPresentation(private val mapper: Mapper<List<ArticlesDomain>, List<ArticlesPresentation>>) :
    Mapper<NewsDomain, NewsPresentation> {
    override fun map(from: NewsDomain) = from.run {
        NewsPresentation(
            articles = mapper.map(articles)
        )
    }
}