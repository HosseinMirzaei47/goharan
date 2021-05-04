plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
}

android {
    addAndroidConfigs()
    addFlavours()
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {

    api(project(":common:android"))

    /* Retrofit */
    api(Libraries.Network.Retrofit.core)
    api(Libraries.Network.Retrofit.moshiConverter)
    api(Libraries.Network.OkHttp.core)
    api(Libraries.Serializable.gson)
    api(Libraries.Network.OkHttp.logger)

    /* Kotshi */
    implementation(Libraries.Serializable.Kotshi.core)
    kapt(Libraries.Serializable.Kotshi.compiler)

    /* Hilt */
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)

    /* Room - Annotation processor. model:android module apis other dependencies */
    kapt(Libraries.AndroidX.Room.compiler)

    /* DataStore */
    api(Libraries.AndroidX.DataStore.dataStore)
    api(Libraries.AndroidX.DataStore.dataStoreCore)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}