# ![](images/icon.png) Coffeegram Multiplatform

[![Compose Version](https://img.shields.io/badge/JetBrains%20Compose-1.3.0--rc05-yellow)](https://github.com/JetBrains/compose-jb)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.8.0-blue.svg)](https://kotlinlang.org)
[![Android CI](https://github.com/phansier/Coffeegram-Desktop/actions/workflows/android.yml/badge.svg)](https://github.com/phansier/Coffeegram-Desktop/actions/workflows/android.yml)
[![Jetc.dev](https://img.shields.io/badge/jetc.dev-77-blue)](https://jetc.dev/issues/077.html)
[![Jetc.dev](https://img.shields.io/badge/jetc.dev-130-blue)](https://jetc.dev/issues/130.html)


Android + Desktop + iOS (!!!) multiplatform app using [Jetbrains Compose](https://github.com/JetBrains/compose-jb) together with StateFlow and MVI

<img src="images/ios.png" alt="drawing" width="300"/>
<img src="images/ios_dark.png" alt="drawing" width="300"/>

![](images/desktop.png)

iOS currently not works with image assets - therefore icons were replaced with color boxes
This project evolved from [Coffeegram Android](https://github.com/phansier/Coffeegram) (with Andorid Jetpack Compose) repository.

## Run on Desktop jvm
`./gradlew run`

## Run on iOS simulator
`./gradlew iosDeployIPhone8Debug --no-configuration-cache`
`./gradlew iosDeployIPadDebug --no-configuration-cache`
