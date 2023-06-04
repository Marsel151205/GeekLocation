plugins {
    id("com.android.application") version "8.0.1" apply false
    id("com.android.library") version "8.0.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false

    // Hilt
    id(Plugins.hilt) version Version.hilt apply false

    // GoogleServices
    id(Plugins.googleServices) version Version.googleServices apply false

    // GoogleMaps
    id(Plugins.mapsPlatform) version Version.mapsPlatform apply false
}