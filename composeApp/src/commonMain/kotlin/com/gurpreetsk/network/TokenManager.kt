package com.gurpreetsk.network

typealias AccessToken = String
typealias RefreshToken = String

interface TokenManager {
    fun getAccessToken(): AccessToken
    fun getRefreshToken(): RefreshToken
    fun fetchNewTokens(): Pair<AccessToken, RefreshToken>
}
