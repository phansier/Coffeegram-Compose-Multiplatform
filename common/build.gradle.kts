plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

fun composeDependency(groupWithArtifact: String) = "$groupWithArtifact:${rootProject.extra["jetbrains_compose_version"]}"

kotlin {
    android()
    jvm("desktop")
    sourceSets {
        named("commonMain") {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(projects.repository)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        named("androidMain") {
            dependencies {
                api(libs.androidx.appcompat)
                api(libs.androidx.coreKtx)
                implementation(libs.threetenabp)
            }
        }
        named("desktopMain") {
            dependencies {
                api(compose.desktop.common)
            }
        }
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8//todo check 11
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}
