object Config {
    const val applicationId = "com.carpet.goharshad"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object BuildPlugins {

    object GradleClassPath {
        const val kotlinVersion = "1.4.32"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

        const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.1"

        const val hiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:2.30.1-alpha"

        const val navSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2"

    }

    object Apply {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val javaLibrary = "java-library"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinParcelize = "kotlin-parcelize"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlin = "kotlin"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val daggerHiltPlugin = "dagger.hilt.android.plugin"
        const val safeArgsKotlinPlugin = "androidx.navigation.safeargs.kotlin"
        const val safeArgsPlugin = "androidx.navigation.safeargs"
    }
}

object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
    const val buildToolsVersion = "30.0.2"
}

object Libraries {
    const val multidex = "com.android.support:multidex:1.0.3"
    const val material = "com.google.android.material:material:1.2.1"
    const val mpchart = "com.github.PhilJay:MPAndroidChart:v3.1.0"

    object PartUtils {
        const val multicalendar =
            "com.part.multicalendarsupport:multicalendar:1.0.0-alpha04"
        const val livetask = "com.part.livetask:part:1.1.2"
        const val formManager = "com.partsoftware:formmanager:1.0.3"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val ktxCore = "androidx.core:core-ktx:1.3.2"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val worker = "androidx.work:work-runtime-ktx:2.5.0"
        const val browser = "androidx.browser:browser:1.3.0"

        object Arch {
            private const val version = "2.1.0"
            const val core = "androidx.arch.core:core-common:$version"
            const val runtime = "androidx.arch.core:core-runtime:$version"
            const val test = "androidx.arch.core:core-testing:$version"
        }

        object Navigation {
            const val version = "2.3.2"
            const val core = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val test = "androidx.navigation:navigation-testing:$version"
        }

        object Fragment {
            private const val version = "1.3.0"
            const val core = "androidx.fragment:fragment-ktx:$version"
            const val test = "androidx.fragment:fragment-testing:$version"
        }

        object Hilt {
            private const val version = "1.0.0-alpha03"
            const val work = "androidx.hilt:hilt-work:$version"
            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object DataStore {
            const val version = "1.0.0-alpha06"
            const val dataStore = "androidx.datastore:datastore-preferences:$version"
            const val dataStoreCore = "androidx.datastore:datastore-core:$version"
        }

        object Room {
            private const val version = "2.2.6"
            const val common = "androidx.room:room-common:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val core = "androidx.room:room-ktx:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val test = "androidx.room:room-testing:$version"
            const val sqlcipher = "net.zetetic:android-database-sqlcipher:4.4.2@aar"
            const val sqlite = "androidx.sqlite:sqlite:2.1.0"
        }

        object LifeCycle {
            private const val version = "2.2.0"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }
    }

    object Hilt {
        private const val version = "2.31.2-alpha"
        const val core = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
    }

    object Kotlin {
        const val jdk =
            "org.jetbrains.kotlin:kotlin-stdlib:${BuildPlugins.GradleClassPath.kotlinVersion}"

        object Coroutine {
            private const val version = "1.4.2"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val core =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Network {
        const val okio = "com.squareup.okio:okio:2.10.0"

        object OkHttp {
            private const val version = "4.9.0"
            const val core = "com.squareup.okhttp3:okhttp:$version"
            const val logger = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object Retrofit {
            private const val version = "2.9.0"
            const val core = "com.squareup.retrofit2:retrofit:$version"
            const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
        }
    }

    object Serializable {
        const val gson = "com.google.code.gson:gson:2.8.6"

        object Kotshi {
            private const val version = "2.3.3"
            const val core = "se.ansman.kotshi:api:$version"
            const val compiler = "se.ansman.kotshi:compiler:$version"
        }
    }

    object Epoxy {
        private const val version = "4.4.1"
        const val core = "com.airbnb.android:epoxy:$version"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        const val processor = "com.airbnb.android:epoxy-processor:$version"
        const val paging = "com.airbnb.android:epoxy-paging:$version"
    }

    object Scale {
        private const val version = "1.0.6"
        const val ssp = "com.intuit.ssp:ssp-android:$version"
        const val sdp = "com.intuit.sdp:sdp-android:$version"
    }

    object ImageUtils {
        const val coil = "io.coil-kt:coil:1.1.1"
        const val lottie = "com.airbnb.android:lottie:3.6.1"
    }

}

object TestLibraries {

    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    private object Versions {
        const val junit4 = "4.13.1"
        const val testRunner = "1.1.2"
        const val espresso = "3.3.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test.ext:junit:${Versions.testRunner}"
}

object DebugLibraries {

    object Versions {
        const val soLoader = "0.9.0"
        const val flipper = "0.72.0"
    }

    const val flipper = "com.facebook.flipper:flipper:${Versions.flipper}"
    const val flipperNetwork = "com.facebook.flipper:flipper-network-plugin:${Versions.flipper}"
    const val flipperNoop = "com.facebook.flipper:flipper-noop:${Versions.flipper}"
    const val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"
}