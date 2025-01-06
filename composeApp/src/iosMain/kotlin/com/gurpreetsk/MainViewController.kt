package com.gurpreetsk

import androidx.compose.ui.window.ComposeUIViewController
import com.gurpreetsk.di.initKoin
import com.gurpreetsk.di.iosAppModule

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin {
            modules(iosAppModule)
        }
    }
) {
    App()
}