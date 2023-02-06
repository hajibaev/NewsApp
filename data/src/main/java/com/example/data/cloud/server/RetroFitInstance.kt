package com.example.data.cloud.server

import com.example.data.cloud.api.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {
    private val loginInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpclient = OkHttpClient.Builder()
        .addInterceptor(loginInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Utils.BASE_URL)
        .client(okHttpclient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}