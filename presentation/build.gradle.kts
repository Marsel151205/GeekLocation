plugins {

    // AndroidLibrary
    id(Plugins.androidLibrary)

    // KotlinAndroid
    id(Plugins.kotlinAndroid)

    // Kapt
    kotlin(Plugins.kapt)

    // Hilt
    id(Plugins.hilt)

    // GoogleServices
    id(Plugins.googleServices)

    // GoogleMaps
    id(Plugins.mapsPlatform)
}

android {
    namespace = Config.Presentation.namespace
    compileSdk = Config.targetAndCompileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetAndCompileSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

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

    // Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // ViewBindingPropertyDelegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingPropertyDelegate)

    // NavComponents
    implementation(Dependencies.NavComponents.navigationUI)
    implementation(Dependencies.NavComponents.navigationFragment)

    //Lifecycle
    implementation(Dependencies.Lifecycle.liveData)
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.viewModelCompose)

    // Firebase
    implementation(Dependencies.Firebase.firebaseAuth)
    implementation(Dependencies.Firebase.firestore)

    // Domain
    implementation(project(":domain"))

    // GoogleMaps
    implementation(Dependencies.Maps.playServicesMaps)
    implementation(Dependencies.Maps.serviceLocation)

    // GoogleServicesAuth
    implementation(Dependencies.GoogleServices.googleServicesAuth)
}
