package com.example.movieapp.data.cloud.provide

import okhttp3.OkHttpClient

interface ProvideOkHttpClientBuilder {
    fun httpOkHttpClient(): OkHttpClient
}