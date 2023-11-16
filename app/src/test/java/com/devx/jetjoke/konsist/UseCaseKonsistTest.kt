package com.devx.jetjoke.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withPackage
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class UseCaseKonsistTest {

    companion object {
        private val domainModuleScope = Konsist.scopeFromProject(moduleName = "domain")
    }

    @Test
    fun `classes end with 'UseCase' suffix should reside in 'domain-useCase' package`() {
        domainModuleScope
            .classes()
            .withNameEndingWith("UseCase")
            .assertTrue {
                it.resideInPackage("..domain.useCase")
            }
    }

    @Test
    fun `classes end with 'UseCase' suffix should have a public method named 'invoke'`() {
        domainModuleScope
            .classes()
            .withPackage("..useCase")
            .withNameEndingWith("UseCase")
            .assertTrue {
                it.hasFunction { function ->
                    function.name == "invoke" && function.hasPublicOrDefaultModifier
                }
            }
    }
}
