// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.kotlin.ksp) apply false
    alias(libs.plugins.detekt)
}

tasks.register("copyGitHooks", Copy::class.java) {
    description = "Copies the git hooks from /git-hooks to the .git folder."
    group = "git hooks"
    from("$rootDir/git-hooks/pre-commit")
    into("$rootDir/.git/hooks/")
}

tasks.register("installGitHooks", Exec::class.java) {
    description = "Installs the pre-commit git hooks from /git-hooks."
    group = "git hooks"
    workingDir = rootDir
    commandLine = listOf("chmod")
    args("-R", "+x", ".git/hooks/")
    dependsOn("copyGitHooks")
    doLast {
        logger.info("Git hook installed successfully.")
    }
}

detekt {
    toolVersion = libs.versions.detektVersion.toString()
    config.setFrom(file("config/detekt/detekt.yml"))
    allRules = true
    buildUponDefaultConfig = true
}

afterEvaluate {
    tasks.getByPath(":app:preBuild").dependsOn(":installGitHooks")
}
