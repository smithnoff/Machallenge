package com.skyven.machallenge.ui.contactos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyven.machallenge.data.models.FavoriteEntity
import com.skyven.machallenge.data.models.UserContact
import com.skyven.machallenge.domain.contacts.GetContactsUseCase
import com.skyven.machallenge.domain.contacts.GetFavoritesUseCase
import com.skyven.machallenge.domain.contacts.InsertIntoFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val insertIntoFavoritesUseCase: InsertIntoFavoritesUseCase,
) : ViewModel() {

    val contactList = MutableLiveData<List<UserContact>>()
    val favoriteList = MutableLiveData<List<FavoriteEntity>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getContacts() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getContactsUseCase()

            if (!result.isNullOrEmpty()) {
                contactList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun addToFavorites(userContact: UserContact) {
        viewModelScope.launch {
            insertIntoFavoritesUseCase(FavoriteEntity.contactToFavorite(userContact))
        }
    }

    fun getFavorites() = viewModelScope.launch {
        val result = getFavoritesUseCase()
        if (!result.isNullOrEmpty()) {
            favoriteList.postValue(result)
        }
    }
}