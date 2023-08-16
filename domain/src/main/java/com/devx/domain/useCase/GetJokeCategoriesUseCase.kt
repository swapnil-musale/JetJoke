package com.devx.domain.useCase

import com.devx.domain.repository.JokeRepository
import javax.inject.Inject

class GetJokeCategoriesUseCase @Inject constructor(private val jokeRepository: JokeRepository) {
    operator fun invoke(): ArrayList<String> {
        return jokeRepository.getJokeCategories()
    }
}
