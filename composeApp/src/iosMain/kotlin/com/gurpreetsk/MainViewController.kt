package com.gurpreetsk

import androidx.compose.ui.window.ComposeUIViewController
import com.gurpreetsk.di.initKoin
import com.gurpreetsk.navigation.HomeScreenNavigation
import com.gurpreetsk.shared.network.iOSNetworkModule
import com.gurpreetsk.shared.storage.di.iOSStorageModule

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin {
            modules(
                iOSStorageModule,
                iOSNetworkModule
            )
        }
    }
) {
    App()
}
