import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

sqldelight {
    database("CoffeeDb") {
        packageName = "ru.beryukhov.repository"
    }
    linkSqlite = true
}

version = "1.0"

val sqldelight_version ="1.5.1"

kotlin {
    android()

    jvm()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Repository for Coffegram"
        homepage = "https://github.com/phansier/Coffeegram"
        ios.deploymentTarget = "14.1"
        frameworkName = "repository"
        // set path to your ios project podfile, e.g. podfile = project.file("../iosApp/Podfile")
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["coroutines_version"]}")

                implementation("com.squareup.sqldelight:runtime:$sqldelight_version")
                implementation("com.squareup.sqldelight:coroutines-extensions:$sqldelight_version")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:$sqldelight_version")
                implementation("com.squareup.sqldelight:coroutines-extensions:$sqldelight_version")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:$sqldelight_version")
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:sqlite-driver:$sqldelight_version")
            }
        }

    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 30
    }
}