enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Coffeegram"
include("app")
include("common")
include("desktop")
include("repository")

includeBuild("build-logic")
