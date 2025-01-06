package com.gurpreetsk.di

import com.gurpreetsk.AndroidDatabaseDriverFactory
import com.gurpreetsk.data.DatabaseDriverFactory
import org.koin.dsl.module

val androidAppModule = module {
    single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(get()) }
}