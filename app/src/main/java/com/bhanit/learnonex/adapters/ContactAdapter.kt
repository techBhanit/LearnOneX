package com.bhanit.learnonex.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bhanit.learnonex.databinding.ContactViewBinding
import com.bhanit.learnonex.models.Contact

class ContactAdapter(private val contacts: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ")
        return contacts.size
    }


    open class ContactViewHolder(private val binding: ContactViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.name.text = contact.name
            binding.number.text = contact.number.toString()
        }
    }

    companion object {
        private const val TAG = "ContactAdapter"
    }
}