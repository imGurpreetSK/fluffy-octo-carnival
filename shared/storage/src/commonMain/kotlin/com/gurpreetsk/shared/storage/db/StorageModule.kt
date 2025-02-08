package com.gurpreetsk.shared.storage.db

import com.gurpreetsk.db.Database
import org.koin.dsl.module

val storageModule = module {
    single { Database.invoke(get<DatabaseDriverFactory>().createDriver()).databaseQueries }
}
