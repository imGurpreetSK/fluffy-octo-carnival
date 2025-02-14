package com.gurpreetsk.shared.storage.kv

import com.russhwolf.settings.Settings

public interface PreferencesManager {

    public fun putString(key: String, value: String)
    public fun getString(key: String): String?

    public fun putBoolean(key: String, value: Boolean)
    public fun getBoolean(key: String): Boolean?

    public fun putInt(key: String, value: Int)
    public fun getInt(key: String): Int?

    public fun putLong(key: String, value: Long)
    public fun getLong(key: String): Long?

    public fun putDouble(key: String, value: Double)
    public fun getDouble(key: String): Double?

    public fun putFloat(key: String, value: Float)
    public fun getFloat(key: String): Float?
}

internal class DefaultPreferencesManager(private val settings: Settings) : PreferencesManager {

    override fun putString(key: String, value: String) = settings.putString(key, value)
    override fun getString(key: String): String? = settings.getStringOrNull(key)

    override fun putBoolean(key: String, value: Boolean) = settings.putBoolean(key, value)
    override fun getBoolean(key: String): Boolean? = settings.getBooleanOrNull(key)

    override fun putInt(key: String, value: Int) = settings.putInt(key, value)
    override fun getInt(key: String): Int? = settings.getIntOrNull(key)

    override fun putLong(key: String, value: Long) = settings.putLong(key, value)
    override fun getLong(key: String): Long? = settings.getLongOrNull(key)

    override fun putDouble(key: String, value: Double) = settings.putDouble(key, value)
    override fun getDouble(key: String): Double? = settings.getDoubleOrNull(key)

    override fun putFloat(key: String, value: Float) = settings.putFloat(key, value)
    override fun getFloat(key: String): Float? = settings.getFloatOrNull(key)
}
