plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.kotlinParcelize)
}


android {
    addAndroidConfigs()
    addFlavours()

    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {

    implementation(project(":data"))
    api(project(":model"))

    /* Hilt */
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)

    /* LiveTask */
    api(Libraries.PartUtils.livetask)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}