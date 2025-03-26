package com.gurpreetsk.feature.screen1

import com.gurpreetsk.db.Album

sealed interface State<T> {
    data class Loading<T>(val data: T? = null) : State<T>
    data class Success<T>(val data: T) : State<T>
    data class Error<T>(val error: Throwable, val data: T? = null) : State<T>
}

data class Screen1Model(
    val data: State<List<Album>>,
) {
    companion object {
        fun default() = Screen1Model(State.Loading())
    }
}
