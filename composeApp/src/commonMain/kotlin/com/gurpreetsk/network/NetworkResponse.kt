package com.gurpreetsk.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<out Data>(
    @SerialName(value = "data") val data: Data?,
    @SerialName(value = "code") val code: Int?,
    @SerialName(value = "message") val message: String?,
    @SerialName(value = "meta") val meta: Metadata? = null
) {

    @Serializable
    data class Metadata(
        @SerialName(value = "start") val start: Int?,
        @SerialName(value = "end") val end: Int?,
        @SerialName(value = "total") val total: Int?,
        @SerialName(value = "last_cursor") val lastCursor: String?,
        @SerialName(value = "has_next") val hasNext: Boolean?,
    )
}
