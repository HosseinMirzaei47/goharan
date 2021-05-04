package com.carpet.goharshad.data.utils

import androidx.datastore.preferences.core.intPreferencesKey

object DataStoreConstants {
    val THEME_KEY = intPreferencesKey("THEME")
    val LANGUAGE_KEY = intPreferencesKey("LANGUAGE")
    val TIME_FORMAT_KEY = intPreferencesKey("TIME_FORMAT")
    val DATA_STORE_NAME = "gs_DATA_STORE"
}