package com.freenow.android_demo.utils

import org.awaitility.Duration
import org.awaitility.kotlin.await

fun awaitUntilAsserted(timeout: Duration = Duration.FIVE_SECONDS, assert: () -> Unit) =
    await.atMost(timeout).ignoreExceptions().untilAsserted(assert)
