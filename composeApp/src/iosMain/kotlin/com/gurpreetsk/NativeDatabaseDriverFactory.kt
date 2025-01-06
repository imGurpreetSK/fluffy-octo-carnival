package com.gurpreetsk

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.gurpreetsk.db.Database
import com.gurpreetsk.data.DatabaseDriverFactory

class NativeDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, "template.db")
    }
}
