package com.bhanit.learnonex.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

object CustomHelper {

    private const val TAG = "CustomHelper"

    fun showToast(message: String, context: Context) {
        Log.d(TAG, "showToast: message $message")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}