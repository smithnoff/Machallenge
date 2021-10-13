package com.skyven.machallenge.di

import android.content.Context
import androidx.room.Room
import com.skyven.machallenge.data.database.ContactsDao
import com.skyven.machallenge.data.database.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideChannelDao(appDatabase: ContactsDatabase): ContactsDao {
        return appDatabase.contactsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ContactsDatabase {
        return Room.databaseBuilder(
            appContext,
            ContactsDatabase::class.java,
            "MachDB"
        ).allowMainThreadQueries().build()
    }
}