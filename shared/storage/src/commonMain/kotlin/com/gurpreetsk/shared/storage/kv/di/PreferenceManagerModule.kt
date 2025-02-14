package com.gurpreetsk.shared.storage.kv.di

import com.gurpreetsk.shared.storage.kv.DefaultPreferencesManager
import com.gurpreetsk.shared.storage.kv.PreferencesManager
import org.koin.core.module.Module
import org.koin.dsl.module

public val preferencesManagerModule: Module = module {
    factory<PreferencesManager> { DefaultPreferencesManager(get()) }
}
