package com.skyven.machallenge.data

import android.util.Log
import com.skyven.machallenge.data.database.ContactsDao
import com.skyven.machallenge.data.models.FavoriteEntity
import com.skyven.machallenge.data.models.UserContact
import com.skyven.machallenge.data.network.ContactsApi
import com.skyven.machallenge.data.providers.ContactsProvider
import com.skyven.machallenge.data.providers.FavoritesProvider
import javax.inject.Inject

class ContactRepository @Inject constructor(
    private val contactApi: ContactsApi,
    private val favoritesDao: ContactsDao,
    private val contactsProvider: ContactsProvider,
    private val favoritesProvider: FavoritesProvider,
) {

    suspend fun getAllContacts(): List<UserContact> {
        try {
            val response = contactApi.getUserContacts()
            contactsProvider.contacts = response.body() ?: mutableListOf()
        }catch (exception:Exception){
            Log.e("exception", exception.message?:"unknow error")
            return mutableListOf()
        }
        return contactsProvider.contacts ?: mutableListOf()
    }

    suspend fun getFavorites(): List<FavoriteEntity> {
        val favorites = favoritesDao.getAllFavorites()
        favoritesProvider.favorites = favorites
        return favoritesProvider.favorites ?: mutableListOf()
    }

    suspend fun addFavorite(favoriteEntity: FavoriteEntity) = favoritesDao.insertFavorite(favoriteEntity)
}