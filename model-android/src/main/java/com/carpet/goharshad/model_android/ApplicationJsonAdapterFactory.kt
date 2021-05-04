package com.carpet.goharshad.model_android

import com.squareup.moshi.JsonAdapter
import se.ansman.kotshi.KotshiJsonAdapterFactory

@KotshiJsonAdapterFactory
object ApplicationJsonAdapterFactory : JsonAdapter.Factory by KotshiApplicationJsonAdapterFactory
