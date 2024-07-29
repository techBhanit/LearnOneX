package com.bhanit.learnonex.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.bhanit.learnonex.R
import com.bhanit.learnonex.dashboard.DashboardActivity
import com.bhanit.learnonex.fragment.MyFragmentActivity
import com.bhanit.learnonex.utils.Constant
import com.bhanit.learnonex.utils.PreferenceHelper

// lazy, lateinit ,!!
class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var mLoginButton: Button

    private lateinit var mEmail: String
    private lateinit var mPassword: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViewAndSetListener()
//        learnPreference()
    }

    private fun learnPreference() {
        Log.d(TAG, "learnPreference: ")
        PreferenceHelper.putString("BHANIT", "Value is Rahul")
        val value = PreferenceHelper.getString("BHANIT")
        Log.d(TAG, "learnPreference: value $value")
    }

    private fun initViewAndSetListener() {
        Log.d(TAG, "initViewAndSetListener: ")
        val emailTextView: EditText = findViewById(R.id.email_edit_text)
        val passwordTextView: EditText = findViewById(R.id.password_edit_text)
        mLoginButton = findViewById(R.id.login_button)
        setOnClickListener(emailTextView, passwordTextView)

    }

    private fun setOnClickListener(emailTextView: EditText, passwordTextView: EditText) {
        Log.d(TAG, "setOnClickListener: ")
        emailTextView.addTextChangedListener { it ->
            Log.d(TAG, "addTextChangedListener: mEmailTextView it $it")
            mEmail = it.toString()
        }
        passwordTextView.addTextChangedListener { it ->
            Log.d(TAG, "addTextChangedListener: mPasswordTextView  it $it")
            mPassword = it.toString()
        }
        mLoginButton.setOnClickListener(this)
    }

    /*
    * == compares the value ,"A"="A" , 1==1, true==false
    * === compares the reference value of object
    * equals method compares the object itself.
    * */
    private fun validateLoginAndOpenDashboard() {
        if (!::mEmail.isInitialized || !::mPassword.isInitialized) {
            Log.d(
                TAG,
                "validateLoginAndOpenDashboard: email is not initialized or password is not initialized"
            )
            return
        }

        Log.d(TAG, "validateLoginAndOpenDashboard: email $mEmail password $mPassword")
        if (mEmail.equals("bhanit@gmail.com", ignoreCase = true) && mPassword.equals(
                "1234",
                true
            )
        ) {
            PreferenceHelper.putString(Constant.KEY.EMAIL_KEY, mEmail)
            PreferenceHelper.putBoolean(
                Constant.KEY.IS_LOGGED_IN, true
            )
            openMyFragmentActivity()
//            openDashboard()
        }
    }

    private fun openDashboard() {
        Log.d(TAG, "openDashboard: ")
        val bundle = Bundle()
        bundle.putString(Constant.KEY.EMAIL_KEY, mEmail)
        bundle.putString(Constant.KEY.PASSWORD_KEY, mPassword)
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }


    private fun openMyFragmentActivity() {
        Log.d(TAG, "openMyFragmentActivity: ")
        val bundle = Bundle()
        bundle.putString(Constant.KEY.EMAIL_KEY, mEmail)
        bundle.putString(Constant.KEY.PASSWORD_KEY, mPassword)
        val intent = Intent(this, MyFragmentActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "onClick: ")
        validateLoginAndOpenDashboard()
    }

    companion object {
        private const val TAG = "Login"
    }
}