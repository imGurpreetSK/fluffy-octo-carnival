package com.gurpreetsk

import android.app.Application
import com.gurpreetsk.di.androidAppModule
import com.gurpreetsk.di.initKoin
import org.koin.android.ext.koin.androidContext

class TemplateApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TemplateApp)
            modules(androidAppModule)
        }
    }
}