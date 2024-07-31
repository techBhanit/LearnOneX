package com.bhanit.learnonex.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bhanit.learnonex.databinding.ContactViewBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        holder.bind("One")
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ")
        return 10
    }


    open class ContactViewHolder(private val binding: ContactViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: String) {
            binding.name.text = contact;
        }
    }

    companion object {
        private const val TAG = "ContactAdapter"
    }
}