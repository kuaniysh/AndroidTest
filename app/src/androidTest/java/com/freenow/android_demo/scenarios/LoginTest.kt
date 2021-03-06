package com.freenow.android_demo.scenarios

import android.Manifest
import androidx.test.rule.GrantPermissionRule
import com.freenow.android_demo.activities.MainActivity
import com.freenow.android_demo.models.TestUser
import com.freenow.android_demo.network.fetchUser
import com.freenow.android_demo.screens.LoginScreen
import com.freenow.android_demo.screens.NavigationMenu
import com.freenow.android_demo.rules.TestRuleComposer
import com.freenow.android_demo.utils.clearPrefs
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

class LoginTest{
    lateinit var tester: TestUser

    private val testSetupRule = TestRuleComposer(MainActivity::class.java).with {
        clearPrefs()
        tester = fetchUser()
    }

    private val permissionsRule = GrantPermissionRule.grant(
        Manifest.permission.ACCESS_FINE_LOCATION)

    @get:Rule
    val rule = RuleChain
        .outerRule(permissionsRule)
        .around(testSetupRule)

    @Test
    fun successfulLoginTest(){
        LoginScreen.enterCredetials(tester.username,tester.password)
        LoginScreen.loginButton.click()
        NavigationMenu.openNavigationMenu()

        NavigationMenu.hasUsername(tester.username)
    }

    @Test
    fun invalidCredentialsLoginTest(){
        //Blank credentials
        LoginScreen.loginButton.click()

        LoginScreen.hasErrorMessage()

        LoginScreen.enterCredetials(tester.username,"")

        LoginScreen.hasErrorMessage()

        LoginScreen.enterCredetials("",tester.password)

        LoginScreen.hasErrorMessage()
    }
}