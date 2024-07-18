package com.bhanit.learnonex.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

// Two ways to create constructor
// primary 1st
// secondary
//
object PreferenceHelper {
    private val TAG = "PreferenceHelper"

    private lateinit var mSharedPreferences: SharedPreferences

    // DataStore and Shared Preference are almost same, but Shared preference runs on main thread, and Data Store runs on background thread.
    /*Create a file with name BHANIT_PREFERENCE with private mode MODE_PRIVATE*/
    fun initPreference(context: Context) {
        Log.d(TAG, "initPreference: context ${context}")
        mSharedPreferences = context.getSharedPreferences(
            Constant.APP.PREFERENCE_NAME,//file name
            Context.MODE_PRIVATE// mode like, private for given context
        ) // Create a file, file type is xml.
    }

    fun putString(key: String, value: String) {
        Log.d(TAG, "puString: ")
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        Log.d(TAG, "getString: ")
        return mSharedPreferences.getString(key, null)
    }

    fun putBoolean(key: String, value: Boolean) {
        Log.d(TAG, "putBoolean: ")
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        Log.d(TAG, "putBoolean: ")
        return mSharedPreferences.getBoolean(key, false)
    }

    fun clearKey(key: String) {
        Log.d(TAG, "putBoolean: ")
        mSharedPreferences.edit().remove(key).apply()
    }

    fun clearPreference() {
        Log.d(TAG, "clearPreference: ")
        mSharedPreferences.edit().clear().apply()
    }

}