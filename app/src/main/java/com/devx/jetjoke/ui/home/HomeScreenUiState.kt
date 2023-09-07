package com.devx.jetjoke.ui.home

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.devx.domain.model.JokeResponse

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val jokeData: JokeResponse? = null,
    val errorMessage: String? = null,
)

class HomeScreenPreviewParameter : CollectionPreviewParameterProvider<HomeScreenUiState>(
    listOf(
        HomeScreenUiState(isLoading = true),
        HomeScreenUiState(errorMessage = "Something went wrong"),
    ),
)
