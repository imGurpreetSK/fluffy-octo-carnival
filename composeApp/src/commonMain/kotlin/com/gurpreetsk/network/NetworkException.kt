package com.gurpreetsk.network

typealias HttpStatusCode = Int

data class NetworkException(
    val code: HttpStatusCode,
    override val message: String,
    override val cause: Throwable?
) : Throwable(message, cause)
