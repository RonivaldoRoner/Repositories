package com.ronivaldoroner.repositories.di

import com.ronivaldoroner.repositories.domain.providers.GitHubProvider
import com.ronivaldoroner.repositories.providers.remote.Retrofit
import com.ronivaldoroner.repositories.providers.remote.api.GitHubApi
import com.ronivaldoroner.repositories.providers.remote.service.GitHubRemoteProvider
import org.koin.dsl.module

val remoteModule = module {

    // region APIs
    single { Retrofit.createWebService(GitHubApi::class.java) }
    //endregion

    //region Providers
    single<GitHubProvider> {
        GitHubRemoteProvider(
            gitHubApi = get()
        )
    }

    //endregion
}