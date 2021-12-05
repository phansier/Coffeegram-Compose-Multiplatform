buildscript {
    val coroutines_version by extra("1.5.2")


    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath(libs.androidGradle)

        classpath(libs.composeGradle)
        classpath(libs.kotlinGradle)
        classpath(libs.sqldelightGradle)
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}