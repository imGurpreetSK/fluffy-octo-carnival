package com.gurpreetsk.shared.storage.di

import com.gurpreetsk.shared.storage.db.AndroidDatabaseDriverFactory
import com.gurpreetsk.shared.storage.db.DatabaseDriverFactory
import com.gurpreetsk.shared.storage.kv.AndroidSettingsFactory
import com.gurpreetsk.shared.storage.kv.SettingsFactory
import org.koin.core.module.Module
import org.koin.dsl.module

public val androidStorageModule: Module = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(get()) }
    single<SettingsFactory> { AndroidSettingsFactory(get()) }
}
