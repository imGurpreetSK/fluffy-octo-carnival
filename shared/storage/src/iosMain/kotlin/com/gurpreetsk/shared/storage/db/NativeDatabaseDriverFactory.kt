package com.gurpreetsk.shared.storage.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.gurpreetsk.db.Database

internal class NativeDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Companion.Schema, "primary.db")
    }
}
