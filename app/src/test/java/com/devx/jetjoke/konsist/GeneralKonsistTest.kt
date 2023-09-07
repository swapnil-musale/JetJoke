package com.devx.jetjoke.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertNot
import org.junit.Test

class GeneralKonsistTest {

    @Test
    fun `no class should use android util log`() {
        Konsist
            .scopeFromProject()
            .files
            .assertNot {
                it.hasImports("android.util..")
            }
    }
}
