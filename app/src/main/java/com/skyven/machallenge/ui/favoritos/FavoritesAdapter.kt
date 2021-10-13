package com.skyven.machallenge.ui.favoritos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skyven.machallenge.R
import com.skyven.machallenge.data.models.FavoriteEntity

class FavoritesAdapter(private val contactList: List<FavoriteEntity>) :
    RecyclerView.Adapter<FavoritesAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.favorites_view, parent, false)
        )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount() = contactList.size

    open class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var contactName = itemView.findViewById<TextView>(R.id.contact_name)
        private var contactEmail = itemView.findViewById<TextView>(R.id.contact_email)
        private var contactPhone = itemView.findViewById<TextView>(R.id.contact_phone)
        private var contactCompany = itemView.findViewById<TextView>(R.id.contact_company)

        fun bind(favoriteEntity: FavoriteEntity) {
            contactName.text = "Nombre: ${favoriteEntity.name}"
            contactEmail.text = "Email: ${favoriteEntity.email}"
            contactPhone.text = "Telf: ${favoriteEntity.phone}"
            contactCompany.text = "Compañia: ${favoriteEntity.company}"
        }
    }
}
