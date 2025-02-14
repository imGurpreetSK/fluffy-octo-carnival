package com.gurpreetsk.shared.storage.kv

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.core.module.Module
import org.koin.dsl.module

internal val androidSettingsModule: Module = module {
    factory<SettingsFactory> { SettingsFactory(get()) }
}

internal class SettingsFactory(private val context: Context) {

    private val factory by lazy { SharedPreferencesSettings.Factory(context) }

    fun getOrCreate(fileName: String): Settings = factory.create(fileName)
}
