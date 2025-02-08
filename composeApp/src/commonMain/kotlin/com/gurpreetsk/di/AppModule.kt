package com.gurpreetsk.di

import com.gurpreetsk.api.KtorApi
import com.gurpreetsk.api.KtorApiImpl
import com.gurpreetsk.api.RemoteApi
import com.gurpreetsk.shared.storage.LocalDataSource
import com.gurpreetsk.shared.storage.Repository
import com.gurpreetsk.feature.screen1.Screen1ViewModel
import com.gurpreetsk.shared.network.di.networkModule
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(
        apiModule,
        repositoryModule,
        viewModelModule,
        networkModule
    )
}

val apiModule = module {
    single<KtorApi> { KtorApiImpl() }
    factory { RemoteApi(get()) }
}

val repositoryModule = module {
    factory { LocalDataSource(get()) }
    single { Repository() }
}

val viewModelModule = module {
    viewModel { Screen1ViewModel() }
}
