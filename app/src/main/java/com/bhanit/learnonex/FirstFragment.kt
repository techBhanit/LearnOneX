package com.bhanit.learnonex

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bhanit.learnonex.databinding.FragmentFirstBinding
import com.bhanit.learnonex.fragment.MyFragmentActivity
import com.bhanit.learnonex.utils.CustomHelper

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment(private val buttonName: String = "One") : Fragment(), View.OnClickListener {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mInteraction: FirstFragmentActivityInteraction

    private lateinit var mEmail: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        setOnClickListener()
        setDataOnText()
    }

    private fun setDataOnText() {
        Log.d(TAG, "setDataOnText: ")
        if (!::mEmail.isInitialized)
            return
        binding.dataFragmentTextview.text = mEmail
    }

    private fun setOnClickListener() {
        Log.d(TAG, "setOnClickListener: ")
        binding.buttonPrevious.setOnClickListener(this)
        binding.buttonNext.setOnClickListener(this)
        binding.showToast.setOnClickListener(this)

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
        mInteraction = context as MyFragmentActivity

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
            R.id.button_previous -> {
                Log.d(TAG, "onClick: button_previous")
                mInteraction.previousCall()
            }

            R.id.button_next -> {
                Log.d(TAG, "onClick: button_next")
                mInteraction.nextCall(binding.editTextView.text.toString())
            }
            R.id.show_toast -> {
                Log.d(TAG, "onClick: ")
                CustomHelper.showToast("SHOW TOAST", requireContext())
            }

        }
    }

    fun passData(email: String) {
        Log.d(TAG, "passData: email $email")
        mEmail = email
    }

    interface FirstFragmentActivityInteraction {
        fun previousCall()
        fun nextCall(data: String)
    }

    companion object {
        private const val TAG = "GAURAV FirstFragment"
    }

}