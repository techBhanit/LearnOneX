package com.bhanit.learnonex.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bhanit.learnonex.R
import com.bhanit.learnonex.databinding.ActivityDashboardBinding
import com.bhanit.learnonex.login.Login
import com.bhanit.learnonex.splash.Test
import com.bhanit.learnonex.utils.Constant
import com.bhanit.learnonex.utils.PreferenceHelper


// ? is nullability operator,
// !! assertion.
class DashboardActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        Log.d(TAG, "onCreate: ")
        getDataFromBundle()
        setOnClickListener()
//        learnAssertionAndNullability()
    }

    private fun setOnClickListener() {
        Log.d(TAG, "setOnClickListener: ")
        mBinding.loginButton.setOnClickListener {
            Log.d(TAG, "setOnClickListener: logout")
            PreferenceHelper.clearPreference()
//            PreferenceHelper.clearKey(Constant.KEY.IS_LOGGED_IN)
            openLogin()
        }
    }

    private fun learnAssertionAndNullability() {
        Log.d(TAG, "learnAssertionAndNullability: ")
        var b: String = "ab"
        val a: String = "ab"

        var c: String? = "hello"

        Log.d(TAG, "learnAssertionAndNullability: b : $b")
        Log.d(TAG, "learnAssertionAndNullability: a : $a")
        Log.d(TAG, "learnAssertionAndNullability: c from Java : ${Test.getCValue()}")
        Log.d(TAG, "learnAssertionAndNullability: c : in Kotlin : $c")


    }

    private fun getDataFromBundle() {
        Log.d(TAG, "getDataFromBundle: ")
        val email: String? = intent.extras?.getString(Constant.KEY.EMAIL_KEY)
        val password: String? = intent.extras?.getString(Constant.KEY.EMAIL_KEY)
        mBinding.email.text = email
        Log.d(
            TAG,
            "getDataFromBundle: receivedValue $email receivedValueInt $password"
        )
    }

    private fun openLogin() {
        Log.d(TAG, "openLogin: ")
        val bundle = Bundle()
        val intent = Intent(this, Login::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    companion object {
        private val TAG = "DashboardActivity"
    }


    /*//Get the bundle
Bundle bundle = getIntent().getExtras();

//Extract the data…
String stuff = bundle.getString(“stuff”); */
}