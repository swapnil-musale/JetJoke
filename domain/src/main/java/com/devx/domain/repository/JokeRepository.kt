package com.devx.domain.repository

import com.devx.domain.model.JokeResponse

interface JokeRepository {
    suspend fun getJoke(): JokeResponse
    fun getJokeCategories(): ArrayList<String>
}
