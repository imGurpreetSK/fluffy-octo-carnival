package com.gurpreetsk.shared.remoteconfig

interface RemoteConfigKey<T> {
    val name: String
    fun value(rawValue: String): T
}

// Helper classes for common types.
class LongConfigKey(override val name: String) : RemoteConfigKey<Long> {
    override fun value(rawValue: String): Long = if (rawValue.isBlank()) {
        0
    } else {
        rawValue.toLong()
    }
}

class DoubleConfigKey(override val name: String) : RemoteConfigKey<Double> {
    override fun value(rawValue: String): Double = if (rawValue.isBlank()) {
        0.0
    } else {
        rawValue.toDouble()
    }
}

data class StringConfigKey(override val name: String) : RemoteConfigKey<String> {
    override fun value(rawValue: String): String = rawValue
}

class BooleanConfigKey(override val name: String) : RemoteConfigKey<Boolean> {
    override fun value(rawValue: String): Boolean = if (rawValue.isBlank()) {
        false
    } else {
        rawValue.toBoolean()
    }
}
