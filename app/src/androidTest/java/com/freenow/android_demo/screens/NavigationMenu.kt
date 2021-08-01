package com.freenow.android_demo.screens

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.freenow.android_demo.R
import com.freenow.android_demo.utils.awaitUntilAsserted

object NavigationMenu:Screen<NavigationMenu>() {
    /**
     * VIEWS
     */

    val usernameLabel = KEditText{withId(R.id.nav_username)}
    val menuButton = KButton{withContentDescription("Open navigation drawer")}

    /**
     * ACTIONS
     */

    fun openNavigationMenu(){
        awaitUntilAsserted { menuButton.isDisplayed() }
        menuButton.click()
    }


    /**
     * ASSERTIONS
     */

    fun hasUsername(username : String) {
        usernameLabel.isDisplayed()
        usernameLabel.hasText(username)
    }
}