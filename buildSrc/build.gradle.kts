import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

buildscript {
    repositories {
        maven {
            url = uri("https://localartifactory.jfrog.io/artifactory/local/")
            artifactUrls("https://localartifactory.jfrog.io/artifactory/local/")
            credentials {
                username = "android-user"
                password = "p9PTCB[^Z}tcM}wn:ZF4NnVNd=DXC-ML=w3/6"
            }
        }
        mavenCentral()
        google()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
    }
}

repositories {
    maven {
        url = uri("https://localartifactory.jfrog.io/artifactory/local/")
        artifactUrls("https://localartifactory.jfrog.io/artifactory/local/")
        credentials {
            username = "android-user"
            password = "p9PTCB[^Z}tcM}wn:ZF4NnVNd=DXC-ML=w3/6"
        }
    }
    mavenCentral()
    google()
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    languageVersion = "1.4.30"
}

dependencies {
    implementation("com.android.tools.build:gradle:4.1.1")
    implementation("com.android.tools.build:gradle-api:4.1.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.30")
}