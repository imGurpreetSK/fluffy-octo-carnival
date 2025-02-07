package com.gurpreetsk.network

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal object NetworkClient {
    fun get(): HttpClient = HttpClient {
        setupHttpResponseValidator()

        install(HttpTimeout) {
            socketTimeoutMillis = 20_000
            connectTimeoutMillis = 20_000
            requestTimeoutMillis = 20_000
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }
            )
        }

        // TODO(gs) 6 Feb, 2025 - Setup bearer auth.
//        install(Auth) {}
    }

    private fun HttpClientConfig<*>.setupHttpResponseValidator() {
        HttpResponseValidator {
            validateResponse {
                // TODO(gs) 6 Feb, 2025 - Parse error body and use as required.
//                if (it.status.value < 200 || it.status.value >= 300) {
//                    throw NetworkException(it.status.value, it.bodyAsText(), null)
//                }
            }
        }
    }
}
