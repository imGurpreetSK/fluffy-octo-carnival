package com.gurpreetsk.network

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Clock
import kotlinx.serialization.json.Json

class NetworkClient(
    private val tokenManager: TokenManager
) {
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

        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(tokenManager.getAccessToken(), tokenManager.getRefreshToken())
                }
                refreshTokens {
                    val (accessToken, refreshToken) = tokenManager.fetchNewTokens()
                    BearerTokens(accessToken, refreshToken)
                }
            }
        }
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
