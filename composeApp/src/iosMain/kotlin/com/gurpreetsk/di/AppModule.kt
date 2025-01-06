package com.gurpreetsk.di

import com.gurpreetsk.NativeDatabaseDriverFactory
import com.gurpreetsk.data.DatabaseDriverFactory
import org.koin.dsl.module

val iosAppModule = module {
    single<DatabaseDriverFactory> { NativeDatabaseDriverFactory() }
}