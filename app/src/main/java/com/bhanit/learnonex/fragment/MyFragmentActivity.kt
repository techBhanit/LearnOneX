package com.bhanit.learnonex.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bhanit.learnonex.FirstFragment
import com.bhanit.learnonex.R
import com.bhanit.learnonex.SecondFragment
import com.bhanit.learnonex.databinding.ActivityMyFragmentBinding

class MyFragmentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMyFragmentBinding

    private val mManager = supportFragmentManager
    private lateinit var mFirstFragment: FirstFragment
    private lateinit var mSecondFragment: SecondFragment
    private lateinit var mCurrentVisibleFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityMyFragmentBinding>(
            this, R.layout.activity_my_fragment
        )

        openFirstFragment()

        Handler(Looper.getMainLooper()).postDelayed({
            openSecondFragment()
        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            openFirstFragment()
        }, 6000)
    }

    private fun openSecondFragment() {
        Log.d(TAG, "openSecondFragment:")
        if (::mCurrentVisibleFragment.isInitialized) hideFragment(mCurrentVisibleFragment)
        if (!::mSecondFragment.isInitialized) {
            mSecondFragment = SecondFragment()
        }
        addShowFragment(mSecondFragment)
    }

    private fun openFirstFragment() {
        Log.d(TAG, "openFirstFragment:")
        if (::mCurrentVisibleFragment.isInitialized) hideFragment(mCurrentVisibleFragment)
        if (!::mFirstFragment.isInitialized) {
            mFirstFragment = FirstFragment()
        }
        addShowFragment(mFirstFragment)
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
        val fragmentTransaction = mManager.beginTransaction()
        if (!fragment.isAdded) {
            Log.d(TAG, "addShowFragment: fragment Added")
            mCurrentVisibleFragment = fragment
            fragmentTransaction.add(R.id.fragment_view, fragment).commitNowAllowingStateLoss()
            return
        }
        showFragment(fragment)
    }


    companion object {
        private const val TAG = "MyFragmentActivity"
    }
}