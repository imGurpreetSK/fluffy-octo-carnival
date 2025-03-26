package com.gurpreetsk.feature.screen1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.gurpreetsk.data.Repository
import com.gurpreetsk.db.Album
import io.github.aakira.napier.Napier
import kt.mobius.compose.rememberMobiusLoop
import kt.mobius.flow.FlowMobius
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Screen1() {
    val repo: Repository = koinInject()
    val (state, eventConsumer) = rememberMobiusLoop(Screen1Model.default(), Screen1Init()) {
        FlowMobius.loop(
            update = Screen1Update,
            effectHandler = Screen1EffectHandler(Screen1ViewEffectHandler(getScreen1ViewActions()), repo)
        )
    }

    Screen1Content(state.value, eventConsumer)
}

@Composable
internal fun Screen1Content(state: Screen1Model, eventConsumer: (Screen1Event) -> Unit) {
    when (val data = state.data) {
        is State.Error -> Text("Error: ${data.error}")
        is State.Loading -> Text("Loading...")
        is State.Success -> Screen1(data.data, eventConsumer)
    }
}

@Composable
internal fun Screen1(albums: List<Album>, eventConsumer: (Screen1Event) -> Unit) {
    LazyColumn(
        modifier = Modifier.safeContentPadding()
    ) {
        items(albums, key = { it.id }) { notification ->
            NotificationRow(notification, eventConsumer)
        }
    }
}

@Composable
internal fun NotificationRow(album: Album, eventConsumer: (Screen1Event) -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { eventConsumer(Screen1Event.Click) },
        verticalAlignment = Alignment.Top,
    ) {
        AsyncImage(
            model = album.thumbnailUrl,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = album.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

private fun getScreen1ViewActions(): Screen1ViewActions = object : Screen1ViewActions {
    override fun showToast(message: String) {
        Napier.i(tag = "HIT") { message }
    }
}
