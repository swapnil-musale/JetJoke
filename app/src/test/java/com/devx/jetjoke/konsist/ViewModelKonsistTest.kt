package com.devx.jetjoke.konsist

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.constructors
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.ext.provider.representsTypeOf
import com.lemonappdev.konsist.api.verify.assert
import org.junit.Test

class ViewModelKonsistTest {

    companion object {
        private val appModuleScope = Konsist.scopeFromProduction(moduleName = "app")
    }

    @Test
    fun `classes extending ViewModel should have 'ViewModel' suffix`() {
        appModuleScope
            .classes()
            .withAllParentsOf(ViewModel::class)
            .assert {
                it.hasNameEndingWith("ViewModel")
            }
    }

    @Test
    fun `ViewModel classes should not receive 'Context' type parameter`() {
        appModuleScope
            .classes()
            .withAllParentsOf(ViewModel::class)
            .constructors
            .assert {
                it.parameters.none { parameter ->
                    parameter.representsTypeOf<Context>()
                }
            }
    }
}
