package com.gurpreetsk.shared.analytics

open class Event (
    val eventName: String,
    val attributes: Map<String, Any?>? = null
)
