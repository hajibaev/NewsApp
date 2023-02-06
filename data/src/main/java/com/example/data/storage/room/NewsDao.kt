package com.example.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.storage.models.StorageModels
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM storageTable")
    fun getStorageMovies(): Flow<List<StorageModels>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveMovie(storage: StorageModels)

    @Query("DELETE FROM storageTable WHERE url =:url")
    fun deleteMovieFromSaveStorage(url: String)
}