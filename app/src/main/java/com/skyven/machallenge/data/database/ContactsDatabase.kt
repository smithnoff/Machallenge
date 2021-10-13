package com.skyven.machallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skyven.machallenge.data.models.FavoriteEntity

@Database(entities = [FavoriteEntity::class],version = 1)
abstract class ContactsDatabase :RoomDatabase() {
  abstract fun contactsDao(): ContactsDao
}