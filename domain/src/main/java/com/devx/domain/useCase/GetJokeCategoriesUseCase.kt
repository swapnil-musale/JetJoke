package com.devx.domain.useCase

import com.devx.domain.repository.JokeRepository
import com.devx.domain.util.NetworkResponse
import javax.inject.Inject

class GetJokeCategoriesUseCase @Inject constructor(private val jokeRepository: JokeRepository) {
    operator fun invoke(): NetworkResponse<List<String>> {
        return jokeRepository.getJokeCategories()
    }
}
