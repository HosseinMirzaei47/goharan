package com.carpet.goharshad.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.carpet.goharshad.data.datastore.GenericDataStore
import com.carpet.goharshad.data.utils.DataStoreConstants.DATA_STORE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.createDataStore(name = DATA_STORE_NAME)

    @Singleton
    @Provides
    fun provideGenericDataStore(dataStore: DataStore<Preferences>): GenericDataStore =
        GenericDataStore(dataStore)
}