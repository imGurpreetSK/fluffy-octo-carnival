package com.gurpreetsk.network.di

import com.gurpreetsk.network.NetworkClient
import com.gurpreetsk.network.NetworkFactory
import org.koin.dsl.module

val networkModule = module {
    single<NetworkClient> { NetworkClient(get()) }
    single<NetworkFactory> { NetworkFactory(get()) }
}
