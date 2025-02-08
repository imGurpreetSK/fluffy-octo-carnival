package com.gurpreetsk.shared.network.di

import com.gurpreetsk.shared.network.DefaultNetworkFactory
import com.gurpreetsk.shared.network.NetworkClient
import com.gurpreetsk.shared.network.NetworkFactory
import org.koin.dsl.module

val networkModule = module {
    single<NetworkClient> { NetworkClient(get()) }
    single<NetworkFactory> { DefaultNetworkFactory(get()) }
}
