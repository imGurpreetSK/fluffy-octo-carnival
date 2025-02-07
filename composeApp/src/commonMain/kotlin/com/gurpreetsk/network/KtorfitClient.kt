package com.gurpreetsk.network

import de.jensklingenberg.ktorfit.Ktorfit

object KtorfitClient {
    fun get(baseUrl: String): Ktorfit {
        return Ktorfit.Builder()
            .httpClient(NetworkClient.get())
            .baseUrl(baseUrl)
            .build()
    }
}
