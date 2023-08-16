package com.devx.data.repository

import com.devx.data.JokeApi
import com.devx.data.mapper.toDto
import com.devx.data.model.JokeCategoryData
import com.devx.domain.model.JokeResponse
import com.devx.domain.repository.JokeRepository
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
