package com.gurpreetsk.data

import com.gurpreetsk.db.Album

internal class LocalDataSource(private val database: AlbumStore) {
    fun getAlbums() = database.getAlbums()
    fun saveAlbums(albums: List<Album>) = database.clearAndCreateAlbums(albums)
}
