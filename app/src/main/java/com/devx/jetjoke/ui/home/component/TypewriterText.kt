package com.devx.jetjoke.ui.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devx.jetjoke.R
import com.devx.jetjoke.theme.JetJokeTheme
import com.devx.jetjoke.util.ThemedPreview
import kotlinx.coroutines.delay

@Composable
fun TypewriterText(texts: List<String>) {
    var textIndex by remember { mutableStateOf(0) }
    var textToDisplay by remember { mutableStateOf("") }

    LaunchedEffect(key1 = texts) {
        texts[textIndex].forEachIndexed { charIndex, _ ->
            textToDisplay = texts[textIndex]
                .substring(
                    startIndex = 0,
                    endIndex = charIndex + 1,
                )
            delay(timeMillis = 80)
        }
        textIndex = (textIndex + 1) % texts.size
        delay(timeMillis = 1000)
    }

    Text(
        text = textToDisplay,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
    )
}

@ThemedPreview
@Composable
private fun TypewriterTextPreview() {
    JetJokeTheme {
        TypewriterText(texts = listOf(element = stringResource(id = R.string.app_tagline)))
    }
}
