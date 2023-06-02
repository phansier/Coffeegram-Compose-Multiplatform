enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Coffeegram"
include("app")
include("common")
include("repository")

includeBuild("build-logic")
