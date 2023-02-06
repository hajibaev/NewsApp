package com.example.di

import android.content.Context
import com.example.utils.resource.ResourceProvider
import com.example.data.cloud.api.NewsApi
import com.example.data.cloud.models.NewsCloud
import com.example.data.cloud.source.news.ArticlesCloudDataImpl
import com.example.data.cloud.source.news.ArticlesCloudDataSource
import com.example.data.cloud.source.storage.CloudDataSourceForStorage
import com.example.data.cloud.source.storage.CloudDataSourceForStorageImpl
import com.example.data.models.ArticlesData
import com.example.data.models.NewsData
import com.example.data.repository.RepositoryImpl
import com.example.data.repository.StorageRepositoryImpl
import com.example.data.storage.models.StorageModels
import com.example.data.storage.room.NewsDao
import com.example.domain.Mapper
import com.example.domain.helper.DispatchersProvider
import com.example.domain.models.ArticlesDomain
import com.example.domain.models.NewsDomain
import com.example.domain.repository.Repository
import com.example.domain.repository.StorageRepository
import com.example.utils.communication.NavigationCommunication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNavigationCommunication(): NavigationCommunication = NavigationCommunication.Base()


    @Provides
    fun provideResourceProvider(
        @ApplicationContext context: Context,
    ): ResourceProvider = ResourceProvider.Base(context = context)

    @Provides
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProvider.Base()

    @Provides
    fun provideArticlesCloudDataSource(
        api: NewsApi,
        mapper: Mapper<NewsCloud, NewsData>,
        dispatchersProvider: DispatchersProvider
    ): ArticlesCloudDataSource =
        ArticlesCloudDataImpl(api = api, mapper = mapper, dispatchersProvider = dispatchersProvider)


    @Provides
    fun provideRepository(
        articlesCloudData: ArticlesCloudDataSource,
        mapper: Mapper<NewsData, NewsDomain>,
        dispatchersProvider: DispatchersProvider
    ): Repository = RepositoryImpl(
        articlesCloudData = articlesCloudData,
        mapper = mapper,
        dispatchersProvider = dispatchersProvider
    )

    @Provides
    fun provideCloudDataSourceForStorage(
        mapper: Mapper<ArticlesData, StorageModels>,
        dao: NewsDao,
        mapList: Mapper<List<StorageModels>, List<ArticlesData>>,
        dispatchersProvider: DispatchersProvider
    ): CloudDataSourceForStorage =
        CloudDataSourceForStorageImpl(
            dao = dao,
            mapper = mapper,
            mapList = mapList,
            dispatchersProvider = dispatchersProvider
        )

    @Provides
    fun provideStorageRepository(
        datasource: CloudDataSourceForStorage,
        mapper: Mapper<ArticlesDomain, ArticlesData>,
        mapList: Mapper<List<ArticlesData>, List<ArticlesDomain>>
    ): StorageRepository =
        StorageRepositoryImpl(datasource = datasource, mapper = mapper, mapList = mapList)
}