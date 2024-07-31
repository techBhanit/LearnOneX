package com.bhanit.learnonex.fragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bhanit.learnonex.ContactFragment
import com.bhanit.learnonex.DashboardFragment
import com.bhanit.learnonex.R
import com.bhanit.learnonex.databinding.ActivityDashboardBinding
import com.bhanit.learnonex.utils.Constant
import com.bhanit.learnonex.utils.CustomHelper

class DashboardActivity : AppCompatActivity(), DashboardFragment.FirstFragmentActivityInteraction,
    ContactFragment.SecondFragmentActivityInteraction {

    private lateinit var mBinding: ActivityDashboardBinding

    private val mManager = supportFragmentManager
    private lateinit var mDashboardFragment: DashboardFragment
    private val mContactFragment: ContactFragment by lazy { ContactFragment() }
    private lateinit var mEmail: String
    private lateinit var mCurrentVisibleFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        mBinding = DataBindingUtil.setContentView<ActivityDashboardBinding>(
            this, R.layout.activity_dashboard
        )
//        Log.d(TAG, "onCreate: mFirstFragment $mFirstFragment mSecondFragment $mSecondFragment")
        setOnClickListeners()
        getDataFromBundle()
        openDashboardFragment()
    }

    private fun setOnClickListeners() {
        Log.d(TAG, "setOnClickListeners: ")
        mBinding.appBar.setOnItemSelectedListener { menuItem ->
            return@setOnItemSelectedListener when (menuItem.itemId) {
                R.id.dashboard_menu_id -> {
                    Log.d(TAG, "setOnClickListeners: dashboard_menu_id ")
                    if (mCurrentVisibleFragment !is DashboardFragment)
                        openDashboardFragment()
                    true
                }

                R.id.contacts_menu_id -> {
                    Log.d(TAG, "setOnClickListeners: contacts_menu_id ")
                    if (mCurrentVisibleFragment !is ContactFragment)
                        openContactFragment()
                    true

                }

                R.id.support -> {
                    Log.d(TAG, "setOnClickListeners: support ")
                    true

                }

                else -> {
                    false
                }
            }

        }
    }

    private fun getDataFromBundle() {
        Log.d(TAG, "getDataFromBundle: ")
        val email: String? = intent.extras?.getString(Constant.KEY.EMAIL_KEY)
        val password: String? = intent.extras?.getString(Constant.KEY.EMAIL_KEY)
        Log.d(
            TAG, "getDataFromBundle: receivedValue $email receivedValueInt $password"
        )
        email?.let { mEmail = it }
    }

    private fun openContactFragment() {
        Log.d(TAG, "openSecondFragment:")
        if (::mCurrentVisibleFragment.isInitialized) hideFragment(mCurrentVisibleFragment)
//        if (!::mSecondFragment.isInitialized) {
//            mSecondFragment = SecondFragment()
//        }
        addShowFragment(mContactFragment)
    }

    private fun openDashboardFragment() {
        Log.d(TAG, "openFirstFragment:")
        if (::mCurrentVisibleFragment.isInitialized) hideFragment(mCurrentVisibleFragment)
        if (!::mDashboardFragment.isInitialized) {
            mDashboardFragment = DashboardFragment()
        }
        addShowFragment(mDashboardFragment)
        mDashboardFragment.passData(mEmail)
    }

    /**
     * Method Helps to hide the fragment
     *
     * @param fragment fragment to hide
     */
    private fun hideFragment(fragment: Fragment) {
        Log.d(TAG, "hideFragment: fragment $fragment")
        val ft: FragmentTransaction = mManager.beginTransaction()
        ft.hide(fragment)
        ft.commit()
    }

    /**
     * Method helps to show the hidden fragment
     *
     * @param fragment fragment to show
     */
    private fun showFragment(fragment: Fragment) {
        Log.d(TAG, "showFragment: fragment $fragment ${fragment.isVisible}")
        mCurrentVisibleFragment = fragment
        val ft = mManager.beginTransaction()
        ft.show(fragment)
        ft.commit()
    }

    /**
     * Method helps to add new fragment or to show hidden fragment.
     *
     * @param fragment fragment to show or add
     */
    private fun addShowFragment(fragment: Fragment) {
        Log.d(TAG, "addShowFragment: $fragment")
        if (!fragment.isAdded) {
            Log.d(TAG, "addShowFragment: fragment Added")
            mCurrentVisibleFragment = fragment
            val fragmentTransaction = mManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment_view, fragment).commit()
            return
        }
        showFragment(fragment)
    }


    companion object {
        private const val TAG = "GAURAV MyFragmentActivity"
    }

    override fun previousCall() {
        Log.d(TAG, "previousCall: ")
        if (mCurrentVisibleFragment is DashboardFragment) {
            CustomHelper.showToast("No previous fragment found.", this)
            return
        }
        openDashboardFragment()
    }

    override fun nextCall(data: String) {
        Log.d(TAG, "nextCall: ")
        if (mCurrentVisibleFragment is ContactFragment) {
            CustomHelper.showToast("No next fragment found.", this)
            return
        }
        mContactFragment.passData(data)
        openContactFragment()
    }


    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed:mCurrentVisibleFragment  $mCurrentVisibleFragment")
        super.onBackPressed()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }
}