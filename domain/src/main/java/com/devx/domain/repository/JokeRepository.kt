package com.devx.domain.repository

import com.devx.domain.model.JokeResponse
import com.devx.domain.util.NetworkResponse

interface JokeRepository {
    suspend fun getJoke(): NetworkResponse<JokeResponse>
    fun getJokeCategories(): NetworkResponse<List<String>>
}
