package com.gurpreetsk.shared.network

import de.jensklingenberg.ktorfit.Ktorfit

interface NetworkFactory {
    fun get(baseUrl: String): Ktorfit
}

internal class DefaultNetworkFactory(
    private val networkClient: NetworkClient
) : NetworkFactory {
    override fun get(baseUrl: String): Ktorfit = Ktorfit.Builder()
        .httpClient(networkClient.get())
        .baseUrl(baseUrl)
        .build()
}
