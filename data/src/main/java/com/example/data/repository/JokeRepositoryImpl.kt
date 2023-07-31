package com.example.data.repository

import com.example.data.JokeApi
import com.example.data.mapper.toDto
import com.example.data.model.JokeCategoryData
import com.example.domain.model.JokeResponse
import com.example.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(private val jokeApi: JokeApi) : JokeRepository {

    override suspend fun getJoke(): JokeResponse {
        return try {
            val response = jokeApi.getJoke()
            response.body().toDto()
        } catch (exception: Exception) {
            JokeResponse(
                joke = "",
                setUp = "",
                delivery = "",
                category = "",
                type = "",
                error = true,
                message = exception.message,
            )
        }
    }

    override fun getJokeCategories(): ArrayList<String> {
        return JokeCategoryData.jokeCategories
    }
}
