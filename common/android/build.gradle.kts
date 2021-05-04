plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
}

android {

    addAndroidConfigs(
        buildTypes = {
            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    buildConfigField("String", "BASE_URL", "\"https://reqres.in/api/\"")
                }
                getByName("debug") {
                    buildConfigField("String", "BASE_URL", "\"https://reqres.in/api/\"")
                }
            }
        })

    addFlavours()

    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {

    api(project(":shared"))
    api(project(":model-android"))

    /* Retrofit */
    api(Libraries.Network.Retrofit.core)
    api(Libraries.Network.Retrofit.moshiConverter)
    api(Libraries.Network.OkHttp.core)
    api(Libraries.Serializable.gson)
    api(Libraries.Network.OkHttp.logger)

    /* Hilt */
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)

    /* Flipper */
    debugApi(DebugLibraries.flipper)
    debugApi(DebugLibraries.soLoader)
    debugApi(DebugLibraries.flipperNetwork)
    releaseApi(DebugLibraries.flipperNoop)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}