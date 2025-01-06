package com.gurpreetsk.data

import com.gurpreetsk.api.RemoteApi

class RemoteDataSource(
    private val remoteApi: RemoteApi
) {
    suspend fun getAlbums() = remoteApi.getAlbums()
}