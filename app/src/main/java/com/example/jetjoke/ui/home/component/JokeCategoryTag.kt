package com.example.jetjoke.ui.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetjoke.R
import com.example.jetjoke.theme.JetJokeTheme

@Composable
fun JokeCategoryTag(
    jokeCategory: String,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = jokeCategory.isNotEmpty(),
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Text(
            text = jokeCategory,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = modifier
                .clip(shape = MaterialTheme.shapes.large)
                .background(color = Color(0xFF95E1D3))
                .padding(horizontal = 24.dp, vertical = 8.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppButtonPreview() {
    JetJokeTheme {
        JokeCategoryTag(jokeCategory = stringResource(id = R.string.app_name))
    }
}
