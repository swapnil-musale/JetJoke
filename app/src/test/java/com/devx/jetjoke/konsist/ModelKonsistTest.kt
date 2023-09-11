package com.devx.jetjoke.konsist

import androidx.annotation.Keep
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withDataModifier
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withPackage
import com.lemonappdev.konsist.api.ext.provider.hasAnnotationOf
import com.lemonappdev.konsist.api.verify.assert
import org.junit.Test

class ModelKonsistTest {

    companion object {
        private val dataModuleScope = Konsist.scopeFromProject(moduleName = "data")
    }

    @Test
    fun `files under 'model' package should be data class only`() {
        dataModuleScope
            .files
            .withPackage("..model")
            .assert {
                it.classes().withDataModifier().isNotEmpty()
            }
    }

    @Test
    fun `classes under 'model' package should be annotated with 'Keep'`() {
        dataModuleScope
            .classes()
            .withPackage("..model")
            .assert {
                it.hasAnnotationOf<Keep>()
            }
    }

    @Test
    fun `classes under 'model' package should extend with 'Mapper' interface`() {
        dataModuleScope
            .classes()
            .withPackage("..model")
            .assert {
                it.hasParents("Mapper")
            }
    }

    @Test
    fun `classes end with 'Dto' suffix should reside in 'data-model' package`() {
        dataModuleScope
            .classes()
            .withNameEndingWith("Dto")
            .assert {
                it.resideInPackage("..data.model")
            }
    }
}
