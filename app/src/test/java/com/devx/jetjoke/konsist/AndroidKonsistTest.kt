package com.devx.jetjoke.konsist

import androidx.activity.ComponentActivity
import androidx.compose.ui.tooling.preview.Preview
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.ext.provider.hasAnnotationOf
import com.lemonappdev.konsist.api.verify.assert
import com.lemonappdev.konsist.api.verify.assertNot
import org.junit.Test

class AndroidKonsistTest {

    @Test
    fun `android activity class name ends with 'Activity'`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withAllParentsOf(ComponentActivity::class)
            .assert {
                it.name.endsWith("Activity")
            }
    }

    @Test
    fun `no class should use android util log`() {
        Konsist
            .scopeFromProject()
            .files
            .assertNot {
                it.hasImports("android.util..")
            }
    }

    @Test
    fun `'Composable' function should not use '@Preview' annotation`() {
        // Composable function should use custom @ThemedPreview annotation which will display preview in light & dark mode.
        Konsist
            .scopeFromProduction("app")
            .files
            .assertNot {
                it.containsFunction { function ->
                    function.hasAnnotationOf<Preview>()
                }
            }
    }
}
