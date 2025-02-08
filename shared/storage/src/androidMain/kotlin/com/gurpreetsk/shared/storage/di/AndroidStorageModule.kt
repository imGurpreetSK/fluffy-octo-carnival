package com.gurpreetsk.shared.storage.di

import com.gurpreetsk.shared.storage.db.AndroidDatabaseDriverFactory
import com.gurpreetsk.shared.storage.db.DatabaseDriverFactory
import org.koin.dsl.module

val androidStorageModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(get()) }
}
