package com.gurpreetsk.shared.storage

import com.gurpreetsk.db.Album
import com.gurpreetsk.shared.storage.db.Database
import com.gurpreetsk.shared.storage.db.DatabaseDriverFactory

class LocalDataSource(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    fun getAlbums() = database.getAlbums()
    fun saveAlbums(albums: List<Album>) = database.clearAndCreateAlbums(albums)
}
