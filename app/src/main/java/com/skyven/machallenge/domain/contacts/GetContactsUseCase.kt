package com.skyven.machallenge.domain.contacts

import com.skyven.machallenge.data.ContactRepository
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(private val contactRepository: ContactRepository) {

    suspend operator fun invoke() = contactRepository.getAllContacts()
}