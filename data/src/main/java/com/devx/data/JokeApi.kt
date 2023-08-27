package com.devx.data

import com.devx.data.model.JokeResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {

    @GET("joke/Any")
    suspend fun getJoke(): Response<JokeResponseDto>
}
