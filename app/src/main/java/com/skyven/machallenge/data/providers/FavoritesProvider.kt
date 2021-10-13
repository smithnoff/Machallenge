package com.skyven.machallenge.data.providers

import com.skyven.machallenge.data.models.FavoriteEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritesProvider @Inject constructor() {
    var favorites :MutableList<FavoriteEntity>? = mutableListOf()
}