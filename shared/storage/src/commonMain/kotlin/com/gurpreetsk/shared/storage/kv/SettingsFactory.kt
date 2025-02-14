package com.gurpreetsk.shared.storage.kv

import com.russhwolf.settings.Settings

internal interface SettingsFactory {
    fun getOrCreate(fileName: String): Settings
}
