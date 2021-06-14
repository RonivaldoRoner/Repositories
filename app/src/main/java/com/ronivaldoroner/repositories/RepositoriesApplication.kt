package com.ronivaldoroner.repositories

import android.app.Application
import com.ronivaldoroner.repositories.di.applicationModules
import com.ronivaldoroner.repositories.di.remoteModule
import com.ronivaldoroner.repositories.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class RepositoriesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        buildDependencyGraph()

    }

    private fun buildDependencyGraph() {
        startKoin {

            androidContext(this@RepositoriesApplication)
            modules(applicationModules)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}