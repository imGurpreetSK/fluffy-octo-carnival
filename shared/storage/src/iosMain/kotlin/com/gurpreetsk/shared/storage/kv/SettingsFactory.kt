package com.gurpreetsk.shared.storage.kv

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.dsl.module

internal val iOSSettingsModule: Module = module {
    factory<SettingsFactory> { SettingsFactory() }
}

internal class SettingsFactory {

    private val factory by lazy { NSUserDefaultsSettings.Factory() }

    fun getOrCreate(fileName: String): Settings = factory.create(fileName)
}
