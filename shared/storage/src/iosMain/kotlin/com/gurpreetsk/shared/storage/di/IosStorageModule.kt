package com.gurpreetsk.shared.storage.di

import com.gurpreetsk.shared.storage.db.DatabaseDriverFactory
import com.gurpreetsk.shared.storage.db.NativeDatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

public val iOSStorageModule: Module = module {
    single<DatabaseDriverFactory> { NativeDatabaseDriverFactory() }
}
