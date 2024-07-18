package com.bhanit.learnonex

import android.app.Application
import android.util.Log
import com.bhanit.learnonex.utils.PreferenceHelper

/*Application is Singleton*/
class LearnOneXApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
        PreferenceHelper.initPreference(this)
    }

    companion object {
        private const val TAG = "LearnOneXApplication"
    }
}