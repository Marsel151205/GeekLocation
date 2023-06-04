plugins {
    // Application
    id(Plugins.application)

    // KotlinAndroid
    id(Plugins.kotlinAndroid)

    // Hilt
    id(Plugins.hilt)

    // Kapt
    kotlin(Plugins.kapt)

    // GoogleServices
    id(Plugins.googleServices)
}

android {
    namespace = Config.App.namespace
    compileSdk = Config.targetAndCompileSdk

    defaultConfig {
        applicationId = Config.App.namespace
        minSdk = Config.minSdk
        targetSdk = Config.targetAndCompileSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // Core
    implementation(Dependencies.Core.core)

    // Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // Domain
    implementation(project(":domain"))

    // Presentation
    implementation(project(":presentation"))

    // Data
    implementation(project(":data"))


    // Core
    implementation(Dependencies.Core.core)

    // AppCompat
    implementation(Dependencies.UIComponents.appCompat)

    // Material
    implementation(Dependencies.UIComponents.material)

    // ConstraintLayout
    implementation(Dependencies.UIComponents.constraintLayout)

    // JUnit
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.extJUnit)

    // EspressoCore
    androidTestImplementation(Dependencies.Test.espressoCore)

    // Firebase
    implementation(Dependencies.Firebase.firebaseAuth)
    implementation(Dependencies.Firebase.firestore)

    // GoogleServicesAuth
    implementation(Dependencies.GoogleServices.googleServicesAuth)
}