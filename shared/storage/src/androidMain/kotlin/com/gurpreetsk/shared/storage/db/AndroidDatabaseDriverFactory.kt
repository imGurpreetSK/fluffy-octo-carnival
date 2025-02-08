package com.gurpreetsk.shared.storage.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.gurpreetsk.db.Database
import com.gurpreetsk.shared.storage.db.DatabaseDriverFactory

internal class AndroidDatabaseDriverFactory(private val context: Context) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Database.Companion.Schema, context, "primary.db")
    }
}
