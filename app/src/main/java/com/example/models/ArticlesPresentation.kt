package com.example.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ArticlesPresentation(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?
) : Parcelable