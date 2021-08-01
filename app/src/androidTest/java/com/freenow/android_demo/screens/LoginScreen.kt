package com.freenow.android_demo.screens

import com.agoda.kakao.common.views.KView
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.freenow.android_demo.R
import com.freenow.android_demo.utils.awaitUntilAsserted

object LoginScreen: Screen<LoginScreen>() {

    /**
     * VIEWS
     */

    val usernameEditText = KEditText{withId(R.id.edt_username)}
    val passwordEditText = KEditText{withId(R.id.edt_password)}
    val loginButton = KButton{withId(R.id.btn_login)}
    val loginIsFailed = KView{withText(R.string.message_login_fail)}

    /**
     * ACTIONS
     */

    fun enterCredetials(username:String,password:String){
        usernameEditText{
            clearText()
            typeText(username)
        }
        passwordEditText{
            clearText()
            typeText(password)
        }
    }

    /**
     * ASSERTIONS
     */

    fun hasErrorMessage(){
        closeSoftKeyboard()
        awaitUntilAsserted { loginIsFailed.isDisplayed() }
    }
}
