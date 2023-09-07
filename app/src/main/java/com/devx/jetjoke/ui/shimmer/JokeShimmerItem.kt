package com.devx.jetjoke.ui.shimmer

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.devx.jetjoke.theme.JetJokeTheme
import com.devx.jetjoke.util.ThemedPreview

@Composable
fun JokeShimmerItem() {
    val size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = "shimmerEffect")
    val startOffsetX by transition.animateFloat(
        label = "",
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1000)),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(height = 20.dp)
            .padding(horizontal = 20.dp)
            .clip(shape = MaterialTheme.shapes.large)
            .background(
                brush = Brush.linearGradient(
                    start = Offset(x = startOffsetX, y = 0f),
                    end = Offset(
                        x = startOffsetX + size.width.toFloat(),
                        y = size.height.toFloat(),
                    ),
                    colors = listOf(
                        Color(value = MaterialTheme.colorScheme.background.value),
                        Color(value = MaterialTheme.colorScheme.background.value),
                    ),
                ),
            ),
    )
}

@ThemedPreview
@Composable
private fun JokeShimmerItemPreview() {
    JetJokeTheme {
        JokeShimmerItem()
    }
}
