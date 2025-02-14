package com.gurpreetsk.shared.storage.kv

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

internal class AndroidSettingsFactory(private val context: Context) : SettingsFactory {

    private val factory by lazy { SharedPreferencesSettings.Factory(context) }

    override fun getOrCreate(fileName: String): Settings = factory.create(fileName)
}
