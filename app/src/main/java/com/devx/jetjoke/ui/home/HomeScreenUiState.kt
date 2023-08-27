package com.devx.jetjoke.ui.home

import com.devx.domain.model.JokeResponse

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val jokeData: JokeResponse? = null,
    val errorMessage: String? = null,
)
