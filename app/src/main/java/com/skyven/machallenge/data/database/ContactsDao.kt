package com.skyven.machallenge.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.skyven.machallenge.data.models.FavoriteEntity

@Dao
interface ContactsDao {

    @Query("SELECT * FROM Favorites")
    suspend fun getAllFavorites(): MutableList<FavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(channel: FavoriteEntity)
}