package com.example.data.cloud.api

import com.example.data.cloud.models.NewsCloud
import com.example.data.cloud.server.Utils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET(Utils.EVERYTHING)
    suspend fun getEverything(
        @Query("q") keyword: String,
        @Query("domains") domains: String? = "bbc.com , euronews.com , edition.cnn.com , " + "news.google.com , aljazeera.com",
        @Query("sortBy") sortBy: String,
        @Query("language") language: String = "en",
        @Query("apiKey") apiKey: String = Utils.API_KEY,
    ): Response<NewsCloud>

    @GET(Utils.TOP_HEADLINES)
    suspend fun getTopHeadLines(
        @Query("q") keyword: String,
        @Query("language") country: String = "en",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = Utils.API_KEY,
    ): Response<NewsCloud>

}