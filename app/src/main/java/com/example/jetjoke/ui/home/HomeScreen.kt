package com.example.jetjoke.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        val joke = viewModel.uiState.collectAsState()

        Text(text = joke.value.jokeData?.setUp.orEmpty())
        Button(onClick = { viewModel.fetchJoke() }) {
            Text(text = "Next")
        }
    }
}
