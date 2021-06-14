package com.ronivaldoroner.repositories.di

import com.ronivaldoroner.repositories.ui.features.repository.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { RepositoryViewModel(remoteProvider = get()) }

}