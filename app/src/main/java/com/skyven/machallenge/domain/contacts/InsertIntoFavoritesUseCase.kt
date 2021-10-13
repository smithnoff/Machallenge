package com.skyven.machallenge.domain.contacts

import com.skyven.machallenge.data.ContactRepository
import com.skyven.machallenge.data.models.FavoriteEntity
import javax.inject.Inject

class InsertIntoFavoritesUseCase @Inject constructor(private val favoritesRepository: ContactRepository)  {

    suspend operator fun invoke(favoriteEntity: FavoriteEntity) = favoritesRepository.addFavorite(favoriteEntity)
}