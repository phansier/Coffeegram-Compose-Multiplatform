path := ./

# detekt:
#     $(path)gradlew detektAll

buildAndroid:
	./gradlew :app:assemble --no-configuration-cache

testCommon:
	./gradlew :common:testDebugUnitTest --no-configuration-cache

localCheck: buildAndroid
