package com.gurpreetsk.data

import com.gurpreetsk.db.Album
import com.gurpreetsk.db.Database

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory.createDriver())
    private val dbQuery = database.databaseQueries

    internal fun getAlbums(): List<Album> {
        return dbQuery.selectAllAlbums(::mapAlbumsSelecting).executeAsList()
    }

    internal fun clearAndCreateAlbums(albums: List<Album>) {
        dbQuery.transaction {
            dbQuery.removeAllAlbums()
            albums.forEach { album ->
                dbQuery.insertAlbum(
                    id = album.id,
                    albumId = album.albumId,
                    title = album.title,
                    url = album.url,
                    thumbnailUrl = album.thumbnailUrl
                )
            }
        }
    }

    private fun mapAlbumsSelecting(
        id: Long,
        albumId: Long,
        title: String,
        url: String,
        thumbnailUrl: String
    ): Album {
        return Album(
            id = id,
            albumId = albumId,
            title = title,
            url = url,
            thumbnailUrl = thumbnailUrl
        )
    }
}