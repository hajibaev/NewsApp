package com.example.di

import com.example.data.cloud.models.ArticlesCloud
import com.example.data.cloud.models.NewsCloud
import com.example.data.data.internet.mappers.news.MapFromArticlesCloudListToData
import com.example.data.data.internet.mappers.news.MapFromArticlesCloudToData
import com.example.data.data.internet.mappers.news.MapFromNewsCloudToData
import com.example.data.data.internet.mappers.storage.MapArticlesDataToStorage
import com.example.data.data.internet.mappers.storage.MapListStorageToData
import com.example.data.data.internet.mappers.storage.MapStorageToData
import com.example.data.data.storage.mappers.MapFromDomainListToStorageList
import com.example.data.data.storage.mappers.MapFromDomainSourceToData
import com.example.data.data.storage.mappers.MapFromDomainToStorageData
import com.example.data.mappers.MapArticlesDataFromListToDomain
import com.example.data.mappers.MapArticlesDataFromToDomain
import com.example.data.mappers.MapArticlesDomainToData
import com.example.data.mappers.MapNewsDataFromToDomain
import com.example.data.models.ArticlesData
import com.example.data.models.NewsData
import com.example.data.storage.models.StorageModels
import com.example.domain.Mapper
import com.example.domain.models.ArticlesDomain
import com.example.domain.models.NewsDomain
import com.example.mappers.MapFromArticlesDomainListToPresentation
import com.example.mappers.MapFromArticlesDomainToPresentation
import com.example.mappers.MapFromNewsDomainToNewsPresentation
import com.example.mappers.SaveMap
import com.example.models.ArticlesPresentation
import com.example.models.NewsPresentation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {

    @Provides
    fun provideMapFromArticlesCloudListToData(mapper: Mapper<ArticlesCloud, ArticlesData>): Mapper<List<ArticlesCloud>, List<ArticlesData>> =
        MapFromArticlesCloudListToData(mapper = mapper)

    @Provides
    fun provideMapFromArticlesCloudToData(): Mapper<ArticlesCloud, ArticlesData> =
        MapFromArticlesCloudToData()

    @Provides
    fun provideMapFromDomainSourceToData(): Mapper<ArticlesDomain, StorageModels> =
        MapFromDomainSourceToData()

    @Provides
    fun provideMapFromDomainListToStorageList(mapper: Mapper<StorageModels, ArticlesDomain>): Mapper<List<StorageModels>, List<ArticlesDomain>> =
        MapFromDomainListToStorageList(mapper = mapper)

    @Provides
    fun provideMapNewsDataFromToDomain(mapper: Mapper<List<ArticlesData>, List<ArticlesDomain>>): Mapper<NewsData, NewsDomain> =
        MapNewsDataFromToDomain(mapper = mapper)

    @Provides
    fun provideMapFromNewsCloudToData(mapper: Mapper<List<ArticlesCloud>, List<ArticlesData>>): Mapper<NewsCloud, NewsData> =
        MapFromNewsCloudToData(mapper = mapper)

    @Provides
    fun provideMapFromArticlesDomainListToPresentation(mapper: Mapper<ArticlesDomain, ArticlesPresentation>): Mapper<List<ArticlesDomain>, List<ArticlesPresentation>> =
        MapFromArticlesDomainListToPresentation(mapper = mapper)


    @Provides
    fun provideMapFromNewsDomainToNewsPresentation(mapper: Mapper<List<ArticlesDomain>, List<ArticlesPresentation>>): Mapper<NewsDomain, NewsPresentation> =
        MapFromNewsDomainToNewsPresentation(mapper = mapper)

    @Provides
    fun provideMapArticlesDataFromListToDomain(mapper: Mapper<ArticlesData, ArticlesDomain>): Mapper<List<ArticlesData>, List<ArticlesDomain>> =
        MapArticlesDataFromListToDomain(mapper = mapper)

    @Provides
    fun provideSaveMap(): Mapper<ArticlesPresentation, ArticlesDomain> = SaveMap()

    @Provides
    fun provideMapListStorageToData(mapper: Mapper<StorageModels, ArticlesData>): Mapper<List<StorageModels>, List<ArticlesData>> =
        MapListStorageToData(mapper = mapper)

    @Provides
    fun provideMapStorageToData(): Mapper<StorageModels, ArticlesData> =
        MapStorageToData()

    @Provides
    fun provideMapArticlesDataFromToDomain(): Mapper<ArticlesData, ArticlesDomain> =
        MapArticlesDataFromToDomain()

    @Provides
    fun provideMapArticlesDataToStorage(): Mapper<ArticlesData, StorageModels> =
        MapArticlesDataToStorage()

    @Provides
    fun provideMapArticlesDomainToData(): Mapper<ArticlesDomain, ArticlesData> =
        MapArticlesDomainToData()

    @Provides
    fun provideMapFromDomainToStorageData(): Mapper<StorageModels, ArticlesDomain> =
        MapFromDomainToStorageData()

    @Provides
    fun provideMapFromArticlesDomainToPresentation(): Mapper<ArticlesDomain, ArticlesPresentation> =
        MapFromArticlesDomainToPresentation()

}