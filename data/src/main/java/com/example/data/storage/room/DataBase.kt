package com.example.data.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.storage.models.StorageModels


@Database(entities = [StorageModels::class], version = 2, exportSchema = true)
abstract class Database : RoomDatabase() {
    abstract fun newsDao(): NewsDao


}