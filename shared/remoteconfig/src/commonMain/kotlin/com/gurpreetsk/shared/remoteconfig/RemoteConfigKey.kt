package com.gurpreetsk.shared.remoteconfig

sealed interface RemoteConfigKey<T> {

    val name: String

    class LongConfigKey(override val name: String) : RemoteConfigKey<Long>

    class DoubleConfigKey(override val name: String) : RemoteConfigKey<Double>

    data class StringConfigKey(override val name: String) : RemoteConfigKey<String>

    class BooleanConfigKey(override val name: String) : RemoteConfigKey<Boolean>
}
