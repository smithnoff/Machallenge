package com.skyven.machallenge.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val company: String
) {
    companion object {
        fun contactToFavorite(userContact: UserContact) = FavoriteEntity(
            id = userContact.id,
            name = if (userContact.name.isNotBlank()) userContact.name else userContact.username,
            email = userContact.email,
            phone = userContact.phone,
            company = userContact.company.name
        )
    }
}