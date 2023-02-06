package com.example.data.mappers

import com.example.data.models.ArticlesData
import com.example.data.models.NewsData
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.domain.models.NewsDomain

class MapNewsDataFromToDomain(private val mapper:  Mapper<List<ArticlesData>, List<ArticlesDomain>>) :
    Mapper<NewsData, NewsDomain> {
    override fun map(from: NewsData) = from.run {
        NewsDomain(
            articles = mapper.map(articles)
        )
    }
}