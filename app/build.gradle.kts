@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id(libs.plugins.kapt.get().pluginId)
    id(libs.plugins.androidx.navigation.get().pluginId)
    id(libs.plugins.ktlint.jlleitschuh.get().pluginId)
}

android {
    namespace = "com.gonzalez.blanchard.WheaTerApp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gonzalez.blanchard.WheaTerApp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    api(project(":data"))
    implementation(project(":domain"))

    implementation(libs.androidx.ktx)
    implementation(platform(libs.compose.bom))

    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))

    // Import Compose Libraries
    implementation(libs.activity.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.material3)
    implementation("androidx.compose.material:material")
    implementation(libs.compose.animation)
    implementation(libs.compose.lifecycle.viewmodel)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.activity)
    implementation(libs.compose.navigation)

    // Import other libraries
    implementation(libs.androidx.constraint)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.dagger.hilt)
    implementation(libs.dagger.hilt.core)
    implementation(libs.zxing)
    implementation(libs.security.crypto)
    implementation(libs.coil)
    implementation(libs.joda.time)

    testImplementation(libs.junit)
    androidTestImplementation(libs.test.ext)
    androidTestImplementation(libs.test.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    kapt(libs.dagger.compiler)
}
