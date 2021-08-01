package com.freenow.android_demo.rules

import android.app.Activity
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.rule.ActivityTestRule

class TestRuleComposer<T : Activity>(activityClass: Class<T>) : IntentsTestRule<T>(activityClass) {
    private val operations = mutableListOf<() -> Unit>()

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()
        operations.forEach { it.invoke() }
    }

    fun with(operation: () -> Unit): ActivityTestRule<T> {
        this.operations.add(operation)
        return this
    }
}