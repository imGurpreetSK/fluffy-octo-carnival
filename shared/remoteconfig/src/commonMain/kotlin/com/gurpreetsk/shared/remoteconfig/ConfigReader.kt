package com.gurpreetsk.shared.remoteconfig

/**
 * Interface for reading remote config values.
 *
 * Intended API usage: `configReader.read(BooleanConfigKey("feature_is_enabled"))`
 *
 * @param T The type of the value to be read.
 * @see RemoteConfigKey for more info and helper classes.
 */
interface ConfigReader<T> {
    fun read(key: RemoteConfigKey<T>, defaultValueOverride: T? = null): T
}

internal interface PlatformConfigReaderDelegate<T> {
    fun read(key: RemoteConfigKey<T>, defaultValueOverride: T? = null): T
}

internal class RemoteConfigReader<T>(
    private val delegate: PlatformConfigReaderDelegate<T>
) : ConfigReader<T> {
    override fun read(key: RemoteConfigKey<T>, defaultValueOverride: T?): T =
        delegate.read(key, defaultValueOverride)
}
