package com.gurpreetsk.shared.remoteconfig

import com.gurpreetsk.shared.remoteconfig.RemoteConfigKey.BooleanConfigKey
import com.gurpreetsk.shared.remoteconfig.RemoteConfigKey.DoubleConfigKey
import com.gurpreetsk.shared.remoteconfig.RemoteConfigKey.LongConfigKey
import com.gurpreetsk.shared.remoteconfig.RemoteConfigKey.StringConfigKey
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.remoteconfig.remoteConfig

/**
 * Read remote config values. This is currently backed by Firebase Remote Config.
 *
 * Intended API usage: `ConfigReader.read(BooleanConfigKey("feature_is_enabled"))`
 *
 * @param T The type of the value to be read.
 * @see RemoteConfigKey for more info and helper classes.
 */
object ConfigReader {
    fun <T> read(key: RemoteConfigKey<T>): T? {
        val value = Firebase.remoteConfig.getValue(key.name)
        return when (key) {
            is BooleanConfigKey -> value.asBoolean()
            is DoubleConfigKey -> value.asDouble()
            is LongConfigKey -> value.asLong()
            is StringConfigKey -> value.asString()
        } as? T
    }
}
