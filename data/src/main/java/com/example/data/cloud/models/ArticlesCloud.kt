package com.example.data.cloud.models

import com.google.gson.annotations.SerializedName

data class ArticlesCloud(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("urlToImage") val urlImage: String?,
    @SerializedName("publishedAt") val publishedAt: String?
)