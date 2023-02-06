package com.example.data.cloud.models

import com.google.gson.annotations.SerializedName

data class NewsCloud(
    @SerializedName("articles") val articles: List<ArticlesCloud>
)
