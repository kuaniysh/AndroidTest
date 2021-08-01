package com.freenow.android_demo.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.test.platform.app.InstrumentationRegistry
import com.freenow.android_demo.models.TestUser

private val instrumentation = InstrumentationRegistry.getInstrumentation()
var appContext = instrumentation.targetContext
const val PREFS_NAME = "FreeNowPrefs"

fun clearPrefs() {
    val sharedPref: SharedPreferences = appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
}

fun saveTestersPrefs(tester:TestUser){
    val sharedPref: SharedPreferences = appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    val editor = sharedPref.edit()
    editor.putString("username", tester.username)
    editor.putString("salt", tester.salt)
    editor.putString("sha256", tester.sha256)
    editor.apply()
}
