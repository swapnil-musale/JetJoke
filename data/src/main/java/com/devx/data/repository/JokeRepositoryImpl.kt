package com.devx.data.repository

import com.devx.data.model.JokeCategoryData
import com.devx.data.source.remote.JokeApi
import com.devx.data.util.networkUtil.safeApiCall
import com.devx.domain.model.JokeResponse
import com.devx.domain.repository.JokeRepository
import com.devx.domain.util.NetworkResponse
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(private val jokeApi: JokeApi) : JokeRepository {

    override suspend fun getJoke(): NetworkResponse<JokeResponse> {
        return safeApiCall { jokeApi.getJoke() }
    }

    override fun getJokeCategories(): NetworkResponse<List<String>> {
        return NetworkResponse.Success(data = JokeCategoryData.jokeCategories)
    }
}
