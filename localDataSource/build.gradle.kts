@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.dagger.hilt.get().pluginId)
    id(libs.plugins.kapt.get().pluginId)
}

android {
    namespace = "com.gonzalez.blanchard.localdatasource"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(libs.androidx.ktx)
    implementation(libs.dagger.hilt)
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.coroutines)
    implementation(libs.androidx.room.rxjava)
    implementation(libs.sqlcipher)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)

    testImplementation(libs.junit)

    kapt(libs.dagger.compiler)
    kapt(libs.androidx.room.compiler)
}
