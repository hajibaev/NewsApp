package com.example.movieapp.data.cloud.provide

import retrofit2.Retrofit

interface ProvideRetrofitBuilder {
    fun provideRetrofitBuilder(): Retrofit.Builder

}