package com.gurpreetsk.feature.screen1

internal class Screen1ViewEffectHandler(
    private val actions: Screen1ViewActions
): ViewEffectHandler {
    override fun handle(effect: Screen1Effect.ViewEffect) {
        when (effect) {
            is Screen1Effect.ViewEffect.Random -> actions.showToast(effect.message)
        }
    }
}
