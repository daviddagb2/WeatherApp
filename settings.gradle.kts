val MAPBOX_DOWNLOADS_TOKEN: String by settings

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "WeatherApp"
include(":app")
include(":data")
include(":localDataSource")
include(":remoteDataSource")
include(":domain")
