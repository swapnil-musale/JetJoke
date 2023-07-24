package com.example.domain.repository

import com.example.domain.model.JokeResponse

interface JokeRepository {
    suspend fun getJoke(): JokeResponse
    fun getJokeCategories(): ArrayList<String>
}
