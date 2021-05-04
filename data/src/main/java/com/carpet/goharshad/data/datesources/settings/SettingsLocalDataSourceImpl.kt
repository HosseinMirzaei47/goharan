package com.carpet.goharshad.data.datesources.settings

import com.carpet.goharshad.data.datastore.SettingManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsLocalDataSourceImpl @Inject constructor(private val settingManager: SettingManager) :
    SettingsLocalDataSource {
    override suspend fun getCurrentTheme(): Flow<Int> = settingManager.getCurrentTheme()

    override suspend fun setCurrentTheme(themeCode: Int) = settingManager.setTheme(themeCode)

    override suspend fun getLanguage(): Flow<Int> = settingManager.getLanguage()

    override suspend fun setLanguage(languageCode: Int) = settingManager.setLanguage(languageCode)

    override suspend fun getTimeFormat(): Flow<Int> = settingManager.getTimeFormat()

    override suspend fun setTimeFormat(timeFormatCode: Int) =
        settingManager.setTimeFormat(timeFormatCode)
}