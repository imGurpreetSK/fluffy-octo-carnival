package com.gurpreetsk.shared.network

import org.koin.dsl.module

val androidNetworkModule = module {
    single<TokenManager> { AndroidTokenManager() }
}

internal class AndroidTokenManager : TokenManager {

    override fun getAccessToken(): String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NfdXVpZCI6IjMwNTU0MTNlLWI2MjktNDQ4OS04NjZmLTAxN2U3NjUyNDc2ZCIsImF1ZCI6ImpnLXVzZXIiLCJleHAiOjE3NDE0OTM0OTIsImlhdCI6MTczODkwMTQ5MiwiaXNzIjoiamctdXMtYXV0aCIsIm5iZiI6MTczODkwMTQ5Miwicm9sZXMiOlsiY2FuZGlkYXRlX3VwZGF0ZSJdLCJ1c2VyX2lkIjoiNjU3MjEzYmExMTE0ZTI5YjA0OWFhNGNhIiwidXNlcl90eXBlIjoiY2FuZGlkYXRlIn0.yMPMvSAivu6lyDPPfpROIEzOZ-4EnkFV-REQ9ecQv74"

    override fun getRefreshToken(): String = "No-Op"

    override fun fetchNewTokens(): Pair<AccessToken, RefreshToken> = "TODO" to "TODO"
}
