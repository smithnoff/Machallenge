package com.skyven.machallenge.ui.contactos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.skyven.machallenge.data.models.UserContact
import com.skyven.machallenge.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsFragment : Fragment() {

    private val contactsViewModel: ContactsViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        initObservables()
        contactsViewModel.getContacts()
    }

    private fun initObservables() {
        contactsViewModel.contactList.observe(viewLifecycleOwner, {
            if(it.isEmpty())
                binding.viewflipperContacts.displayedChild = 2
            else
            binding.contactsRecycler.adapter = ContactsAdapter(it, ::addContactToFavorites)
        })
        contactsViewModel.isLoading.observe(viewLifecycleOwner, {
            it?.let { isLoading ->
                binding.viewflipperContacts.displayedChild = if (isLoading) {
                    0
                } else {
                    1
                }
            }
        })
    }

    private fun initViews() {
        with(binding) {
            contactsRecycler.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun addContactToFavorites(userContact: UserContact) {
        contactsViewModel.addToFavorites(userContact)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}