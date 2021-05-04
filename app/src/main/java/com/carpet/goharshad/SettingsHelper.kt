package com.carpet.goharshad

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.carpet.goharshad.android.ApplicationScope
import com.carpet.goharshad.data.utils.DataStoreConstants
import com.carpet.goharshad.data.utils.DataStoreConstants.DATA_STORE_NAME
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject


@ApplicationScope
class SettingsHelper @Inject constructor(private val context: Context) {

    private val config = Configuration(context.resources.configuration)

    init {
        initLocale()
        initTheme()
    }

    private fun setConfigLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        config.setLocale(locale)
    }

    private fun initLocale() {
        var langType: Int

        runBlocking {
            val preferences: Preferences =
                context.createDataStore(name = DATA_STORE_NAME).data.first()
            langType = preferences[DataStoreConstants.LANGUAGE_KEY] ?: 0
        }

        when (langType) {
            1 -> {
                setConfigLocale("fa")
            }
            else -> {
                setConfigLocale("en")
            }
        }
    }

    private fun initTheme() {

        var themeType: Int

        runBlocking {
            val first: Preferences = context.createDataStore(name = DATA_STORE_NAME).data.first()
            themeType = first[DataStoreConstants.THEME_KEY] ?: 2
        }

        when (themeType) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

    fun getModifiedContext(): Context {
        return context.createConfigurationContext(config)
    }
}