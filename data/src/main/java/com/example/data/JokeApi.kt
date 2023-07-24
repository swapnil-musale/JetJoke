package com.example.data

import com.example.data.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {

    @GET("joke/Programming")
    suspend fun getJoke(): Response<JokeResponse>
}
