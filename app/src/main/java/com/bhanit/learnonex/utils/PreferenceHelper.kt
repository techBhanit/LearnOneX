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

    /*Create a file with name BHANIT_PREFERENCE with private mode MODE_PRIVATE*/
    fun initPreference(context: Context) {
        Log.d(TAG, "initPreference: context ${context}")
        mSharedPreferences = context.getSharedPreferences("BHANIT_PREFERENCE", Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String) {
        Log.d(TAG, "puString: ")
        mSharedPreferences.edit().putString(key, value).commit()
    }

    fun getString(key: String): String? {
        Log.d(TAG, "getString: ")
        return mSharedPreferences.getString(key, null)
    }

}