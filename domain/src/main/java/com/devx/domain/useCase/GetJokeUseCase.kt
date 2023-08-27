package com.devx.domain.useCase

import com.devx.domain.model.JokeResponse
import com.devx.domain.repository.JokeRepository
import com.devx.domain.util.NetworkResponse
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(private val jokeRepository: JokeRepository) {
    suspend operator fun invoke(): NetworkResponse<JokeResponse> {
        return jokeRepository.getJoke()
    }
}
