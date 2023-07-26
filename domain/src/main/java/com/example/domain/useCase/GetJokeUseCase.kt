package com.example.domain.useCase

import com.example.domain.model.JokeResponse
import com.example.domain.repository.JokeRepository
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(private val jokeRepository: JokeRepository) {
    suspend operator fun invoke(): JokeResponse {
        return jokeRepository.getJoke()
    }
}
