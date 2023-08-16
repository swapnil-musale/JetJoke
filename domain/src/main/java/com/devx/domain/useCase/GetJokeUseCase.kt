package com.devx.domain.useCase

import com.devx.domain.model.JokeResponse
import com.devx.domain.repository.JokeRepository
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(private val jokeRepository: JokeRepository) {
    suspend operator fun invoke(): JokeResponse {
        return jokeRepository.getJoke()
    }
}
