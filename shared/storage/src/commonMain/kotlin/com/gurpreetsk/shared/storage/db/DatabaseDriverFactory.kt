package com.gurpreetsk.shared.storage.db

import app.cash.sqldelight.db.SqlDriver

internal interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
