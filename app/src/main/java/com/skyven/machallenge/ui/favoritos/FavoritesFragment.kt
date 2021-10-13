package com.skyven.machallenge.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skyven.machallenge.databinding.FragmentDashboardBinding
import com.skyven.machallenge.ui.contactos.ContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private val contactsViewModel: ContactsViewModel by viewModels()
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        initObservables()
        contactsViewModel.getFavorites()
    }

    private fun initViews() {
        with(binding) {
            favoritesRecycler.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initObservables(){
        contactsViewModel.favoriteList.observe(viewLifecycleOwner,{
            binding.favoritesViewFlipper.displayedChild = if(it.isEmpty()) 0 else 1

                binding.favoritesRecycler.adapter = FavoritesAdapter(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}