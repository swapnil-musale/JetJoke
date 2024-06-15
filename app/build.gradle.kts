plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.detekt)
    alias(libs.plugins.compose.compiler)
}
tasks.configureEach {
    if (name == "compileDebugKotlin") {
        dependsOn(tasks.detekt)
        mustRunAfter(tasks.detekt)
    }
}
android {
    namespace = "com.devx.jetjoke"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devx.jetjoke"
        minSdk = 21
        targetSdk = 34
        versionCode = 33
        versionName = "1.0.6"

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
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.domain)
    implementation(projects.data)

    implementation(platform(libs.kotlin.bom))
    implementation(libs.bundles.androidx.compose.bom)

    implementation(libs.core.ktx)
    implementation(libs.activity.compose)
    implementation(libs.androidx.splashScreen)
    implementation(libs.androidx.lifecycle)

    implementation(libs.compose.lifecycle)
    implementation(libs.compose.viewmodel)
    implementation(libs.compose.navigation)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)
    ksp(libs.hilt.compiler)

    implementation(libs.bundles.retrofit)
    ksp(libs.moshi.codegen)

    testImplementation(libs.junit.test)
    testImplementation(libs.konsist)

    androidTestImplementation(libs.espresso.test)
    androidTestImplementation(libs.junit.extension.test)

    debugImplementation(libs.compose.ui.tooling.test)
    debugImplementation(libs.compose.manifest.test)
}
