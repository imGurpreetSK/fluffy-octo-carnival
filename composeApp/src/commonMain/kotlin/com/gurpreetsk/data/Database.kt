package com.gurpreetsk.data

import com.gurpreetsk.db.Album
import com.gurpreetsk.db.DatabaseQueries

internal class AlbumStore(private val dbQuery: DatabaseQueries) {

    internal fun getAlbums(): List<Album> {
        dbQuery.transaction {
            dbQuery.removeAllAlbums()
        }
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
