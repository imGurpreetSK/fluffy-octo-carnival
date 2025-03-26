package com.gurpreetsk.feature.screen1

import kt.mobius.First
import kt.mobius.Init

internal class Screen1Init : Init<Screen1Model, Screen1Effect> {
    override fun init(model: Screen1Model): First<Screen1Model, Screen1Effect> =
        First.first(Screen1Model.default(), Screen1Effect.FetchAlbums)
}
