package com.devx.jetjoke.di

import com.devx.domain.repository.JokeRepository
import com.devx.domain.useCase.GetJokeCategoriesUseCase
import com.devx.domain.useCase.GetJokeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetJokeUseCase(jokeRepository: JokeRepository): GetJokeUseCase {
        return GetJokeUseCase(jokeRepository = jokeRepository)
    }

    @Provides
    fun provideGetJokeCategoriesUseCase(jokeRepository: JokeRepository): GetJokeCategoriesUseCase {
        return GetJokeCategoriesUseCase(jokeRepository = jokeRepository)
    }
}
