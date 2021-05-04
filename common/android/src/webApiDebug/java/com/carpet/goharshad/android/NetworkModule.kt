package com.carpet.goharshad.android

import com.carpet.goharshad.android.BuildConfig.BASE_URL
import com.carpet.goharshad.model_android.ApplicationJsonAdapterFactory
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkFlipperPlugin(): NetworkFlipperPlugin = NetworkFlipperPlugin()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        networkFlipperPlugin: NetworkFlipperPlugin,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(networkFlipperPlugin))
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(ApplicationJsonAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}
