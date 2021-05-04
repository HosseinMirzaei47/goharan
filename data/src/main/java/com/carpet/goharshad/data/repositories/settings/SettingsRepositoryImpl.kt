package com.carpet.goharshad.data.repositories.settings

import com.carpet.goharshad.data.datesources.settings.SettingsLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataSource: SettingsLocalDataSource
) : SettingsRepository {

    override suspend fun getCurrentTheme(): Flow<Int> = dataSource.getCurrentTheme()

    override suspend fun setCurrentTheme(themeCode: Int) = dataSource.setCurrentTheme(themeCode)

    override suspend fun getLanguage(): Flow<Int> = dataSource.getLanguage()

    override suspend fun setLanguage(languageCode: Int) = dataSource.setLanguage(languageCode)

    override suspend fun getTimeFormat(): Flow<Int> = dataSource.getTimeFormat()

    override suspend fun setTimeFormat(timeFormatCode: Int) =
        dataSource.setTimeFormat(timeFormatCode)
}