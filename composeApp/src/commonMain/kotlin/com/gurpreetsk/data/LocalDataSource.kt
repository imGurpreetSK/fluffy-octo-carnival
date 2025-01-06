package com.gurpreetsk.data

import com.gurpreetsk.db.Album

class LocalDataSource(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    fun getAlbums() = database.getAlbums()
    fun saveAlbums(albums: List<Album>) = database.clearAndCreateAlbums(albums)
}