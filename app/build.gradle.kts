plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.example.jetjoke"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jetjoke"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(libs.bundles.androidx.compose.bom)
    implementation(platform(libs.kotlin.bom))

    implementation(libs.core.ktx)
    implementation(libs.androidx.splashScreen)
    implementation(libs.activity.compose)
    implementation(libs.compose.navigation)
    implementation(libs.compose.lifecycle)
    implementation(libs.androidx.lifecycle)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)
    ksp(libs.hilt.compiler)

    implementation(libs.bundles.retrofit)
    ksp(libs.moshi.codegen)

    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(libs.test.junitExtension)

    debugImplementation(libs.test.compose.ui.tooling)
    debugImplementation(libs.test.compose.manifest)
}

kapt {
    correctErrorTypes = true
}
