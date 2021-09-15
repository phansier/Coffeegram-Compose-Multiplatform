// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val jetbrains_compose_version by extra("1.0.0-alpha4-build348")
    val kotlin_version by extra("1.5.30")
    val coroutines_version by extra("1.5.0")
    val appcompat_version by extra("1.3.0")
    val core_ktx_version by extra("1.5.0")
    //val realm_version by extra("0.5.0")
    val sqldelight_version by extra("1.5.1")
    val compilesdk_version by extra("31")


    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

        //for sqldelight
        maven ("https://www.jetbrains.com/intellij-repository/releases" )
        maven ("https://jetbrains.bintray.com/intellij-third-party-dependencies" )
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.compose:compose-gradle-plugin:$jetbrains_compose_version")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        //classpath("io.realm.kotlin:gradle-plugin:$realm_version")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqldelight_version")
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        //maven("https://dl.bintray.com/kotlin/kotlinx/")//for org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.3
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}