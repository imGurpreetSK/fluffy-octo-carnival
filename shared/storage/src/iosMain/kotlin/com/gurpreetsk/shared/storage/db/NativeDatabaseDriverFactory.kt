package com.gurpreetsk.shared.storage.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.gurpreetsk.db.Database

class NativeDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Companion.Schema, "template.db")
    }
}
