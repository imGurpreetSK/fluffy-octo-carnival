package com.gurpreetsk.shared.storage.db

import com.gurpreetsk.db.Database
import org.koin.core.module.Module
import org.koin.dsl.module

public val storageModule: Module = module {
    single { Database.invoke(get<DatabaseDriverFactory>().createDriver()).databaseQueries }
}
