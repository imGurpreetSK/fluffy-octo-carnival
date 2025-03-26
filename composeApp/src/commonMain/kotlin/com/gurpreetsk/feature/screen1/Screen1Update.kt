package com.gurpreetsk.feature.screen1

import com.gurpreetsk.feature.screen1.State.*
import kt.mobius.Next
import kt.mobius.Update

internal object Screen1Update : Update<Screen1Model, Screen1Event, Screen1Effect> {
    override fun update(
        model: Screen1Model,
        event: Screen1Event
    ): Next<Screen1Model, Screen1Effect> = when (event) {
        Screen1Event.FetchInProgress -> Next.next(model.copy(Loading()))
        is Screen1Event.FetchFailed -> Next.next(model.copy(Error(event.error)))
        is Screen1Event.FetchSuccessful -> Next.next(model.copy(Success(event.albums)))
        Screen1Event.Click -> Next.dispatch(Screen1Effect.ViewEffect.Random("Random"))
    }
}
