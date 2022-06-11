buildscript {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
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
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}