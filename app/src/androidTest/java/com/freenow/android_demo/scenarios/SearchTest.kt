package com.freenow.android_demo.scenarios

import android.Manifest
import androidx.test.rule.GrantPermissionRule
import com.freenow.android_demo.activities.MainActivity
import com.freenow.android_demo.models.TestUser
import com.freenow.android_demo.network.fetchUser
import com.freenow.android_demo.rules.TestRuleComposer
import com.freenow.android_demo.screens.DriversProfileScreen
import com.freenow.android_demo.screens.MainScreen
import com.freenow.android_demo.utils.saveTestersPrefs
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

class SearchTest {
    lateinit var tester: TestUser

    private val testSetupRule = TestRuleComposer(MainActivity::class.java).with {
        tester = fetchUser()
        saveTestersPrefs(tester)
    }

    private val permissionsRule = GrantPermissionRule.grant(
            Manifest.permission.ACCESS_FINE_LOCATION)

    @get:Rule
    val rule = RuleChain
            .outerRule(permissionsRule)
            .around(testSetupRule)

    @Test
    fun searchDriverTest() {
        val testQuery = "sa"
        val expectedResult = "Samantha Reed"

        MainScreen.searchFor(testQuery)
                .clickOnItem(expectedResult)

        DriversProfileScreen.hasName(expectedResult)
                .callToDriver()
                .hasDialerIntent()
    }
}