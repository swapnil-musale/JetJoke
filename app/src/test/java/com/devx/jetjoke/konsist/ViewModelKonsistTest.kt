package com.devx.jetjoke.konsist

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.constructors
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.provider.hasAnnotationOf
import com.lemonappdev.konsist.api.ext.provider.representsTypeOf
import com.lemonappdev.konsist.api.verify.assert
import com.lemonappdev.konsist.api.verify.assertNot
import dagger.hilt.android.lifecycle.HiltViewModel
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
    fun `classes end with 'ViewModel' suffix should be annotated with 'HiltViewModel'`() {
        appModuleScope
            .classes()
            .withNameEndingWith("ViewModel")
            .assert {
                it.hasAnnotationOf<HiltViewModel>()
            }
    }

    @Test
    fun `classes end with 'ViewModel' suffix should not extend with 'AndroidViewModel'`() {
        appModuleScope
            .classes()
            .withNameEndingWith("ViewModel")
            .assertNot {
                it.hasParents("AndroidViewModel")
            }
    }

    @Test
    fun `classes end with 'ViewModel' suffix should not have import of Android ViewModel`() {
        appModuleScope
            .files
            .withNameEndingWith("ViewModel")
            .assertNot {
                it.hasImports("androidx.lifecycle.AndroidViewModel")
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
