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

