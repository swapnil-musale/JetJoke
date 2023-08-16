package com.devx.jetjoke.di

import com.devx.data.JokeApi
import com.devx.data.repository.JokeRepositoryImpl
import com.devx.domain.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideJokeRepository(jokeApi: JokeApi): JokeRepository {
        return JokeRepositoryImpl(jokeApi = jokeApi)
    }
}
