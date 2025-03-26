package com.gurpreetsk.feature.screen1

import com.gurpreetsk.shared.network.NetworkResponse
import de.jensklingenberg.ktorfit.http.GET
import kotlinx.serialization.Serializable

interface NotificationEndpoint {
    @GET("user-service/v4/notifications/list?page=0&start=0&end=25")
    suspend fun getNotifications(): NetworkResponse<NotificationResponse>
}

@Serializable
data class NotificationResponse(
    val paginated: List<Notification>
)

@Serializable
data class Notification(
    val id: String,
    val type: String,
    val message: String,
    val jobTitle: String,
    val senderName: String,
    val senderImage: String,
    val companyName: String,
    val fromRead: String,
    val toRead: String,
    val createdAt: String,
    val updatedAt: String
)
