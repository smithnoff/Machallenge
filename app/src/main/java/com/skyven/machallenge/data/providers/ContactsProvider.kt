package com.skyven.machallenge.data.providers

import com.skyven.machallenge.data.models.UserContact
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactsProvider @Inject constructor() {
    var contacts :MutableList<UserContact>? = mutableListOf()
}
