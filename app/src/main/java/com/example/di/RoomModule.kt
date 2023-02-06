package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.data.storage.room.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

private const val DB_NAME = "news_item.db"

@Module
@InstallIn(SingletonComponent::class)

class RoomModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database = Room.databaseBuilder(
        context,
        Database::class.java,
        DB_NAME

    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideNewsDao(database: Database) = database.newsDao()

}