package com.bhanit.learnonex.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bhanit.learnonex.MainActivity
import com.bhanit.learnonex.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        delayAndOpenMainActivity()
    }

    private fun delayAndOpenMainActivity() {
        Log.d(TAG, "delayAndOpenMainActivity: ")
        val mainIntent: Intent = Intent(
            this,
            MainActivity::class.java
        )

        val runnable = Runnable {
            startActivity(mainIntent)
            this.finish()
        }
        Handler(Looper.getMainLooper()).postDelayed(
            runnable, 3000
        )
    }

    companion object {
        private const val TAG = "SplashActivity"
    }
}