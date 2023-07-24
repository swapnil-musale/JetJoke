package com.example.jetjoke.ui.home

import com.example.domain.model.JokeResponse

data class HomeScreenState(
    val isLoading: Boolean = false,
    val jokeData: JokeResponse? = null,
)
