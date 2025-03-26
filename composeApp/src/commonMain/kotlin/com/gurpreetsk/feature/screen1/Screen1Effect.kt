package com.gurpreetsk.feature.screen1

sealed interface Screen1Effect {
    data object FetchAlbums : Screen1Effect
    sealed interface ViewEffect : Screen1Effect {
        data class Random(val message: String) : ViewEffect
    }
}
