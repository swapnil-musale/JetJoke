package com.devx.jetjoke.konsist

import androidx.activity.ComponentActivity
import androidx.compose.ui.tooling.preview.Preview
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withAllParentsOf
import com.lemonappdev.konsist.api.ext.provider.hasAnnotationOf
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class AndroidKonsistTest {

    @Test
    fun `android activity class name ends with 'Activity'`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withAllParentsOf(ComponentActivity::class)
            .assertTrue {
                it.name.endsWith("Activity")
            }
    }

    @Test
    fun `no class should use android util log`() {
        Konsist
            .scopeFromProject()
            .files
            .assertFalse {
                it.hasImportWithName("android.util..")
            }
    }

    @Test
    fun `'Composable' function should not use '@Preview' annotation`() {
        // Composable function should use custom @ThemedPreview annotation which will display preview in light & dark mode.
        Konsist
            .scopeFromProduction("app")
            .files
            .assertFalse {
                it.hasFunction { function ->
                    function.hasAnnotationOf<Preview>()
                }
            }
    }
}
