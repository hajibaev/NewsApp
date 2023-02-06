package com.example.movieapp.data.cloud.provide

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class ProvideConverterFactoryImpl : ProvideConverterFactory {
    override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
}