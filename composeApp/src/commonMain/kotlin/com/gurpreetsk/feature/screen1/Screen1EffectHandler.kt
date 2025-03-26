package com.gurpreetsk.feature.screen1

import com.gurpreetsk.data.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kt.mobius.flow.FlowTransformer
import kt.mobius.flow.subtypeEffectHandler

internal class Screen1EffectHandler(
    private val viewEffectHandler: ViewEffectHandler,
    private val repository: Repository
) : FlowTransformer<Screen1Effect, Screen1Event> by subtypeEffectHandler({

    addConsumer<Screen1Effect.ViewEffect> { viewEffectHandler.handle(it) }

    addTransformer<Screen1Effect.FetchAlbums> {
        it
            .onStart { Screen1Event.FetchInProgress }
            .map {
                delay(2_000)
                repository.getAlbums()
            }
            .map { Screen1Event.FetchSuccessful(it) }
            .catch { Screen1Event.FetchFailed(it) }
    }
})
