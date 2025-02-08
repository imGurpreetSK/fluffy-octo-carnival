package com.gurpreetsk.di

import com.gurpreetsk.api.KtorApi
import com.gurpreetsk.api.KtorApiImpl
import com.gurpreetsk.api.RemoteApi
import com.gurpreetsk.data.AlbumStore
import com.gurpreetsk.data.LocalDataSource
import com.gurpreetsk.data.Repository
import com.gurpreetsk.feature.screen1.Screen1ViewModel
import com.gurpreetsk.shared.network.di.networkModule
import com.gurpreetsk.shared.storage.db.storageModule
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val apiModule = module {
    single<KtorApi> { KtorApiImpl() }
    factory { RemoteApi(get()) }
}

private val repositoryModule = module {
    factory { AlbumStore(get()) }
    factory { LocalDataSource(get()) }
    factory { Repository(get()) }
}

private val viewModelModule = module {
    viewModel { Screen1ViewModel(get()) }
}

val allModules = listOf(
    // Koin modules provided by core shared modules.
    networkModule,
    storageModule,

    // Feature modules.
    apiModule,
    repositoryModule,
    viewModelModule,
)

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(allModules)
}
