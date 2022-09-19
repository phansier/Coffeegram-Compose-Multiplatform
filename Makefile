path := ./

detekt:
	$(path)gradlew detektAll

buildAndroid:
	./gradlew :app:assemble --no-configuration-cache

testCommon:
	./gradlew :common:testDebugUnitTest --no-configuration-cache

localCheck: detekt buildAndroid


## Run on Desktop jvm
runDesktop:
	./gradlew run

## Run on iOS simulator
runIphone:
	./gradlew iosDeployIPhone8Debug --no-configuration-cache

runIpad:
	./gradlew iosDeployIPadDebug --no-configuration-cache
