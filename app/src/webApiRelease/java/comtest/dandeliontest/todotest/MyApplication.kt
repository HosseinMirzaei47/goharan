package com.carpet.goharshad

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class MyApplication : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()
        setupEpoxyController()
    }

    private fun setupEpoxyController() {
        val handler = EpoxyAsyncUtil.getAsyncBackgroundHandler()
        EpoxyController.defaultDiffingHandler = handler
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(getHiltWorkerFactory())
            .build()
    }

    private fun getHiltWorkerFactory(): HiltWorkerFactory {
        return EntryPointAccessors.fromApplication(
            applicationContext,
            HiltWorkerFactoryEntryPoint::class.java
        ).getWorkerFactoryEntryPoint()
    }

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface HiltWorkerFactoryEntryPoint {
        fun getWorkerFactoryEntryPoint(): HiltWorkerFactory
    }
}