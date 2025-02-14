package com.gurpreetsk.shared.storage.kv

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings

internal object IosSettingsFactory : SettingsFactory {

    private val factory by lazy { NSUserDefaultsSettings.Factory() }

    override fun getOrCreate(fileName: String): Settings = factory.create(fileName)
}
