package com.bhanit.learnonex

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhanit.learnonex.adapters.ContactAdapter
import com.bhanit.learnonex.databinding.FragmentContactBinding
import com.bhanit.learnonex.fragment.DashboardActivity
import com.bhanit.learnonex.models.Address
import com.bhanit.learnonex.models.Contact

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ContactFragment : Fragment(), View.OnClickListener {


    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mInteraction: SecondFragmentActivityInteraction
    private lateinit var mData: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        setOnClickListener()
        setDataOnTextView()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        Log.d(TAG, "setRecyclerView: ")
        val contacts = getListOfContacts()
        binding.recyclerView.adapter = ContactAdapter(contacts)
        val linearLayoutManager =
            LinearLayoutManager(requireContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager)
    }

    private fun getListOfContacts(): ArrayList<Contact> {
        Log.d(TAG, "getListOfContacts: ")
        val contactList = arrayListOf<Contact>();
        for (i in 1..50) {
            val contact = Contact(
                id = i,
                name = "Rahul + $i",
                number = (i * 111111111),
                address = Address(road = "dummy", pinCode = i)
            )
            contactList.add(contact)
        }
        return contactList
    }

    private fun setDataOnTextView() {
        Log.d(TAG, "setDataOnTextView: ")
        if (!::mData.isInitialized) {
            return
        }
    }

    private fun setOnClickListener() {
        Log.d(TAG, "setOnClickListener: ")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mInteraction = context as DashboardActivity

    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(v: View) {
        Log.d(TAG, "onClick: ")
        // When is similiar to switch
        when (v.id) {

        }
    }

    fun passData(data: String) {
        Log.d(TAG, "passData: data $data")
        mData = data
    }

    interface SecondFragmentActivityInteraction {
        fun previousCall()
        fun nextCall(data: String)
    }

    companion object {
        private const val TAG = "GAURAV SecondFragment"
    }
}