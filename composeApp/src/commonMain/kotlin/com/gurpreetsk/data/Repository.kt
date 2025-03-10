package com.gurpreetsk.data

import com.gurpreetsk.db.Album

internal class Repository(private val localDataSource: LocalDataSource) {

    fun getAlbums(forceRefresh: Boolean = false): List<Album> {
        val cachedAlbums = localDataSource.getAlbums()
        return if (cachedAlbums.isNotEmpty() && !forceRefresh) {
            cachedAlbums
        } else {
            buildList {
                add(
                    Album(
                        id = 1,
                        albumId = 1,
                        title = "Genshin Impact",
                        url = "https://google.com",
                        thumbnailUrl = ""
                    )
                )
                add(
                    Album(
                        id = 2,
                        albumId = 2,
                        title = "Genshin Impact 2",
                        url = "https://google.com",
                        thumbnailUrl = ""
                    )
                )
                add(
                    Album(
                        id = 3,
                        albumId = 3,
                        title = "Genshin Impact 3",
                        url = "https://google.com",
                        thumbnailUrl = ""
                    )
                )
            }.also { albums ->
                localDataSource.saveAlbums(albums)
            }
        }
    }
}
