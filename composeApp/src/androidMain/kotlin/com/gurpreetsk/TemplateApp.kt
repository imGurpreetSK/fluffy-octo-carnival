package com.gurpreetsk

import android.app.Application
import com.gurpreetsk.di.initKoin
import com.gurpreetsk.shared.network.androidNetworkModule
import com.gurpreetsk.shared.storage.di.androidStorageModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext

class TemplateApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@TemplateApp)
            modules(
                androidStorageModule,
                androidNetworkModule
            )
        }

        if (BuildConfig.DEBUG) {
            Napier.base(DebugAntilog())
        }
    }
}
