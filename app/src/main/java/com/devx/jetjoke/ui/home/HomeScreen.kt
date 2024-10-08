package com.devx.jetjoke.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.devx.data.util.networkUtil.Constant
import com.devx.jetjoke.R
import com.devx.jetjoke.theme.JetJokeTheme
import com.devx.jetjoke.ui.actions.AppActions
import com.devx.jetjoke.ui.actions.ShareJokeAction
import com.devx.jetjoke.ui.home.component.HomeHeader
import com.devx.jetjoke.ui.home.component.JokeCategoryTag
import com.devx.jetjoke.ui.home.component.TypewriterText
import com.devx.jetjoke.ui.shimmer.JokeShimmerItem
import com.devx.jetjoke.util.ThemedPreview

@Composable
fun HomeScreen(
    uiState: HomeScreenUiState,
    loadNextJoke: () -> Unit,
    action : (AppActions)-> Unit,
) {
    var displayJoke by remember { mutableStateOf("") }

    LaunchedEffect(key1 = uiState.jokeData) {
        when (uiState.jokeData?.type) {
            Constant.JOKE_TYPE_SINGLE -> {
                displayJoke = "${uiState.jokeData.joke}"
            }

            Constant.JOKE_TYPE_TWO_PART -> {
                displayJoke = "${uiState.jokeData.setUp} - ${uiState.jokeData.delivery}"
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) { paddingValues ->
        HomeHeader(modifier = Modifier.padding(paddingValues = paddingValues))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 500.dp)
                .padding(start = 16.dp, end = 16.dp, top = 140.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AnimatedContent(
                    modifier = Modifier.weight(weight = 1f),
                    targetState = displayJoke,
                    label = "jokeText",
                ) {
                    if (uiState.isLoading) {
                        Column(verticalArrangement = Arrangement.Center) {
                            JokeShimmerItem()
                            Spacer(modifier = Modifier.height(height = 12.dp))
                            JokeShimmerItem()
                        }
                    } else {
                        TypewriterText(texts = listOf(it))
                    }
                }

                JokeCategoryTag(
                    jokeCategory = uiState.jokeData?.category.orEmpty(),
                    modifier = Modifier.padding(bottom = 50.dp),
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 470.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Image(
                modifier = Modifier
                    .size(size = 64.dp)
                    .clip(shape = MaterialTheme.shapes.extraLarge)
                    .background(color = MaterialTheme.colorScheme.primary)
                    .clickable { loadNextJoke() }
                    .padding(all = 8.dp),
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = stringResource(R.string.get_next_joke_button),
            )
            Image(
                modifier = Modifier
                    .size(size = 64.dp)
                    .clip(shape = MaterialTheme.shapes.extraLarge)
                    .background(color = MaterialTheme.colorScheme.primary)
                    .clickable { action.invoke(ShareJokeAction(displayJoke)) }
                    .padding(all = 8.dp),
                painter = painterResource(id = R.drawable.baseline_share_24),
                contentDescription = stringResource(R.string.button_to_share_joke),
            )
        }
    }
}

@ThemedPreview
@Composable
private fun HomeScreenPreview(@PreviewParameter(HomeScreenPreviewParameter::class) uiState: HomeScreenUiState) {
    JetJokeTheme {
        HomeScreen(
            uiState = uiState,
            loadNextJoke = {},
            action = {},
        )
    }
}
