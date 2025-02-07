package com.gurpreetsk.network

import de.jensklingenberg.ktorfit.Ktorfit

class NetworkFactory(
    private val networkClient: NetworkClient
) {
    fun get(baseUrl: String): Ktorfit = Ktorfit.Builder()
        .httpClient(networkClient.get())
        .baseUrl(baseUrl)
        .build()
}
