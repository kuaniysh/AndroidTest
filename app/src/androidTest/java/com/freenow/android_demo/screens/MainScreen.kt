package com.freenow.android_demo.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.freenow.android_demo.R
import com.freenow.android_demo.utils.awaitUntilAsserted

object MainScreen : Screen<MainScreen>() {

    /**
     * VIEWS
     */

    val searchEditText = KEditText { withId(R.id.textSearch) }

    /**
     * ACTIONS
     */

    fun searchFor(query: String): MainScreen {
        searchEditText {
            awaitUntilAsserted {isVisible()}
            clearText()
            typeText(query)
        }
        return this
    }

    fun clickOnItem(query: String) {
        onView(withText(query))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click())
    }
}
