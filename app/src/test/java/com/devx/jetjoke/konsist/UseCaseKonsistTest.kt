package com.devx.jetjoke.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withPackage
import com.lemonappdev.konsist.api.verify.assert
import org.junit.Test

class UseCaseKonsistTest {

    companion object {
        private val domainModuleScope = Konsist.scopeFromProject(moduleName = "domain")
    }

    @Test
    fun `classes with 'UseCase' suffix should reside in 'useCase' package`() {
        domainModuleScope
            .classes()
            .withNameEndingWith("UseCase")
            .assert {
                it.resideInPackage("..useCase")
            }
    }

    @Test
    fun `classes with 'UseCase' suffix should have a public method named 'invoke'`() {
        domainModuleScope
            .classes()
            .withPackage("..useCase")
            .withNameEndingWith("UseCase")
            .assert {
                it.containsFunction { function ->
                    function.name == "invoke" && function.hasPublicOrDefaultModifier
                }
            }
    }
}
