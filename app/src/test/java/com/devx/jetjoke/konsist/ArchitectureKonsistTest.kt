package com.devx.jetjoke.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

class ArchitectureKonsistTest {

    @Test
    fun `clean architecture module should have correct dependencies`() {
        Konsist
            .scopeFromProduction()
            .assertArchitecture {
                val presentation = Layer("app", "com.devx.jetjoke..")
                val data = Layer("data", "com.devx.data..")
                val domain = Layer("domain", "com.devx.domain..")

                presentation.dependsOn(domain, data)
                data.dependsOn(domain)
                domain.dependsOnNothing()
            }
    }
}
