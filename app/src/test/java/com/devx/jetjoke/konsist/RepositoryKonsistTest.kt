package com.devx.jetjoke.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assert
import org.junit.Test

class RepositoryKonsistTest {

    companion object {
        private val domainModuleScope = Konsist.scopeFromProject(moduleName = "domain")
        private val dataModuleScope = Konsist.scopeFromProject(moduleName = "data")
    }

    @Test
    fun `interface ends with 'Repository' suffix should reside in 'domain-repository' package`() {
        domainModuleScope
            .interfaces()
            .withNameEndingWith("Repository")
            .assert {
                it.resideInPackage("..domain.repository")
            }
    }

    @Test
    fun `classes ends with 'RepositoryImpl' suffix should reside in 'data-repository' package`() {
        dataModuleScope
            .classes()
            .withNameEndingWith("RepositoryImpl")
            .assert {
                it.resideInPackage("..data.repository..")
            }
    }
}
