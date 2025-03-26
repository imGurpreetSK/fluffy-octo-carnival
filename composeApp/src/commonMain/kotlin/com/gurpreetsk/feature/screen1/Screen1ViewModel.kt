package com.gurpreetsk.feature.screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gurpreetsk.data.Repository
import com.gurpreetsk.db.Album
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class Screen1ViewModel(private val repository: Repository) : ViewModel() {

    private val _uiState = MutableStateFlow<Screen1State>(Screen1State.Loading)
    val state: StateFlow<Screen1State> = _uiState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = Screen1State.Loading
        )

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            _uiState.update { Screen1State.Loading }
            try {
//                val notifications: List<Notification> = networkFactory
//                    .get("https://platform.jobget.com/")
//                    .createNotificationEndpoint()
//                    .getNotifications()
//                    .data?.paginated ?: emptyList()
//                Napier.d { notifications.toString() }
//                _uiState.update { Screen1State.Result(notifications) }

                val albums = repository.getAlbums()
                _uiState.update { Screen1State.Result(albums) }
            } catch (e: Exception) {
                Napier.e(e) { e.message.toString() }
                _uiState.update { Screen1State.Error(e) }
            }
        }
    }
}

sealed class Screen1State {
    data object Loading : Screen1State()
    data class Result(val items: List<Album>) : Screen1State()
    data class Error(val error: Throwable) : Screen1State()
}
