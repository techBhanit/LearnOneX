package com.bhanit.learnonex.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bhanit.learnonex.R
import com.bhanit.learnonex.fragment.DashboardActivity
import com.bhanit.learnonex.login.LoginActivity
import com.bhanit.learnonex.utils.Constant
import com.bhanit.learnonex.utils.PreferenceHelper


// Static is keyword, we use it when we want to assign the one time memory
// of the variable or any method in an application at runtime.

// Thread: A single unit of process.
// 1. Main Thread// UI Thread : blocking of Main thread is not good. It causes crash.
// 2. Background Thread. // We can not update ui it.
// Looper.getMainLooper() is used for switching from background top main thread

// Handler :
//        val handle = Handler(Looper.getMainLooper())
//
//        handle.postDelayed(runnable,3000)
//
//        handle.postDelayed({
//
//        },300)

// Bundle: Bundle is used to collect the data and pass data from one activity to another within application.
// Intent: Intent, pass data between anywhere.
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(TAG, "onCreate: before ")
        checkIsLoggedIn()
    }

    /*
    * scope function in kotlin, // Scope function are the function used for write code in a clear and readable way.
    * let, -> it
    * with,
    * apply -> this
    * run,
    * also
    * */
    private fun checkIsLoggedIn() {
        Log.d(TAG, "checkIsLoggedIn: ")
        val isLoggedIn = PreferenceHelper.getBoolean(
            Constant.KEY.IS_LOGGED_IN
        )
        waitAndOpenActivity(isLoggedIn)
//        if (isLoggedIn) PreferenceHelper.getString(
//            Constant.KEY.EMAIL_KEY
//        )?.let { value -> //final
//            waitAndOpenDashboardActivity(
//                value
//            )
//            return@let
//        }
//        waitAndOpenActivity(isLoggedIn)
    }

    private fun waitAndOpenActivity(loggedIn: Boolean) {
        Log.d(TAG, "waitAndOpenActivity: loggedIn $loggedIn")
        val bundle = Bundle().apply {
            if (loggedIn) putString(
                Constant.KEY.EMAIL_KEY, PreferenceHelper.getString(
                    Constant.KEY.EMAIL_KEY
                )
            )
            return@apply
        }
        Handler(Looper.getMainLooper()).postDelayed({
            openActivity(
                bundle
            )
        }, 5000)
    }

    private fun openActivity(bundle: Bundle) { //
        val intent =
            Intent(
                this,
                if (bundle.isEmpty) LoginActivity::class.java else DashboardActivity::class.java
            )
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
        private val TAG = "SplashActivity"
    }/*/Create the bundle
Bundle bundle = new Bundle();

//Add your data to bundle
bundle.putString(“stuff”, getrec);

//Add the bundle to the intent
i.putExtras(bundle);
*/

}


