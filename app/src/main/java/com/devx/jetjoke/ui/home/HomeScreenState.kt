package com.devx.jetjoke.ui.home

import com.devx.domain.model.JokeResponse

data class HomeScreenState(
    val isLoading: Boolean = false,
    val jokeData: JokeResponse? = null,
)
