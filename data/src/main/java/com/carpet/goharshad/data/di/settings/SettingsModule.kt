package com.carpet.goharshad.data.di.settings

import com.carpet.goharshad.data.datesources.settings.SettingsLocalDataSource
import com.carpet.goharshad.data.datesources.settings.SettingsLocalDataSourceImpl
import com.carpet.goharshad.data.repositories.settings.SettingsRepository
import com.carpet.goharshad.data.repositories.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    abstract fun bindSettingsDataSource(impl: SettingsLocalDataSourceImpl): SettingsLocalDataSource

    @Binds
    abstract fun bindSettingsRepository(impl: SettingsRepositoryImpl): SettingsRepository

}