package com.example.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "storageTable")
class StorageModels(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val url: String?,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String?
)