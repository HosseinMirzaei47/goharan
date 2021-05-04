package com.carpet.goharshad.data.repositories.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun getCurrentTheme(): Flow<Int>
    suspend fun setCurrentTheme(themeCode: Int)
    suspend fun getLanguage(): Flow<Int>
    suspend fun setLanguage(languageCode: Int)
    suspend fun getTimeFormat(): Flow<Int>
    suspend fun setTimeFormat(timeFormatCode: Int)
}