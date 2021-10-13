package com.skyven.machallenge.data.network

import com.skyven.machallenge.data.models.UserContact
import retrofit2.Response
import retrofit2.http.GET

interface ContactsApi {

    @GET("users")
    suspend fun getUserContacts(): Response<MutableList<UserContact>>
}