package com.example.di

import com.example.data.cloud.api.NewsApi
import com.example.movieapp.data.cloud.provide.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class ProvideModule {

    @Provides
    fun provideMakeService(
        retrofitBuilder: ProvideRetrofitBuilder
    ): MakeService = MakeServiceImpl(retrofitBuilder = retrofitBuilder)

    @Provides
    fun provideProductService(
        makeService: MakeService
    ): NewsApi = makeService.service(NewsApi::class.java)


    @Provides
    fun provideProvideConverterFactory(): ProvideConverterFactory = ProvideConverterFactoryImpl()

    @Provides
    fun provideProvideInterceptorDebug(): ProvideInterceptor = ProvideInterceptorImpl.Debug()


    @Provides
    fun provideProvideOkHttpClientBuilder(provideInterceptor: ProvideInterceptor):
            ProvideOkHttpClientBuilder =
        ProvideOkHttpClientBuilderImpl(provideInterceptor = provideInterceptor)

    @Provides
    fun provideProvideRetrofitBuilder(
        provideConverterFactory: ProvideConverterFactory,
        provideOkHttpClientBuilder: ProvideOkHttpClientBuilder
    ): ProvideRetrofitBuilder =
        ProvideRetrofitBuilderImpl(
            provideConverterFactory = provideConverterFactory,
            provideOkHttpClientBuilder = provideOkHttpClientBuilder
        )


}