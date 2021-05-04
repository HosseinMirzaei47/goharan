package com.carpet.goharshad.data.datastore

import com.carpet.goharshad.data.utils.DataStoreConstants.LANGUAGE_KEY
import com.carpet.goharshad.data.utils.DataStoreConstants.THEME_KEY
import com.carpet.goharshad.data.utils.DataStoreConstants.TIME_FORMAT_KEY
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingManager @Inject constructor(
    private val dataStore: GenericDataStore
) {

    suspend fun getCurrentTheme(): Flow<Int> = dataStore.getValue(THEME_KEY, 2)

    suspend fun getLanguage(): Flow<Int> = dataStore.getValue(LANGUAGE_KEY, 0)

    suspend fun getTimeFormat(): Flow<Int> = dataStore.getValue(TIME_FORMAT_KEY, 0)

    suspend fun setTheme(themeCode: Int) {
        dataStore.setValue(themeCode, THEME_KEY)
    }

    suspend fun setLanguage(languageCode: Int) {
        dataStore.setValue(languageCode, LANGUAGE_KEY)
    }

    suspend fun setTimeFormat(timeFormatCode: Int) {
        dataStore.setValue(timeFormatCode, TIME_FORMAT_KEY)
    }
}