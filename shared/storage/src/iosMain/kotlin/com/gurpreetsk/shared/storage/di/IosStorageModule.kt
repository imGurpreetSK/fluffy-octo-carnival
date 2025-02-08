package com.gurpreetsk.shared.storage.di

import com.gurpreetsk.shared.storage.db.DatabaseDriverFactory
import com.gurpreetsk.shared.storage.db.NativeDatabaseDriverFactory
import org.koin.dsl.module

val iOSStorageModule = module {
    single<DatabaseDriverFactory> { NativeDatabaseDriverFactory() }
}
