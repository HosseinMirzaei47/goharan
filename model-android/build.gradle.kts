plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
}

android {
    addAndroidConfigs()
    addFlavours()

    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()

    @Suppress("UnstableApiUsage")
    buildFeatures.dataBinding = true
}


dependencies {
    implementation(Libraries.Kotlin.jdk)
    implementation(Libraries.AndroidX.ktxCore)
    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    /* Retrofit */
    api(Libraries.Network.Retrofit.gsonConverter)
    api(Libraries.Serializable.gson)

    /* Kotshi */
    api(Libraries.Serializable.Kotshi.core)
    kapt(Libraries.Serializable.Kotshi.compiler)

    /* Room */
    api(Libraries.AndroidX.Room.runtime)
    api(Libraries.AndroidX.Room.core)
    kapt(Libraries.AndroidX.Room.compiler)

}
