package com.gurpreetsk.feature.screen1

import com.gurpreetsk.db.Album

internal sealed interface Screen1Event {
    data object Click : Screen1Event
    data object FetchInProgress : Screen1Event
    data class FetchSuccessful(val albums: List<Album>) : Screen1Event
    data class FetchFailed(val error: Throwable) : Screen1Event
}
