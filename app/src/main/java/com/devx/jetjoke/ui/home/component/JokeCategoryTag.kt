package com.devx.jetjoke.ui.home.component

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devx.jetjoke.R
import com.devx.jetjoke.theme.JetJokeTheme
import com.devx.jetjoke.theme.tagColor
import com.devx.jetjoke.util.ThemedPreview

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
                .background(color = tagColor)
                .padding(horizontal = 24.dp, vertical = 8.dp),
        )
    }
}

@ThemedPreview
@Composable
private fun AppButtonPreview() {
    JetJokeTheme {
        JokeCategoryTag(jokeCategory = stringResource(id = R.string.app_name))
    }
}
