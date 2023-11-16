plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.detekt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.configureEach {
    if (name == "compileDebugKotlin") {
        dependsOn(tasks.detekt)
        mustRunAfter(tasks.detekt)
    }
}
dependencies {
    implementation(libs.javax.inject)
}
