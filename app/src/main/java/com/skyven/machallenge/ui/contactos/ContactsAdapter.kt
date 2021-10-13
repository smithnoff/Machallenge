package com.skyven.machallenge.ui.contactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skyven.machallenge.R
import com.skyven.machallenge.data.models.UserContact

class ContactsAdapter(private val contactList: List<UserContact>, private val listener:(UserContact)->Unit) :
    RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false)
        )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contactList[position],listener)
    }

    override fun getItemCount() = contactList.size

    open class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var contactName = itemView.findViewById<TextView>(R.id.contact_name)
        private var btnAddFav = itemView.findViewById<TextView>(R.id.btn_add_favorites)

        fun bind(userContact: UserContact, listener: (UserContact) -> Unit) {
            contactName.text =
                if (userContact.name.isNotBlank()) userContact.name else userContact.username
            btnAddFav.setOnClickListener {
                listener.invoke(userContact)
            }
        }
    }
}
