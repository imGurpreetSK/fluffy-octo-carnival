package com.gurpreetsk.utils

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

object LoggingUtils {

    // TODO(gs) 6 Feb, 2025 - Call from iOS.
    fun initialize() {
        Napier.base(DebugAntilog())
    }
}
