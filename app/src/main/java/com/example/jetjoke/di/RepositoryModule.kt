package com.example.jetjoke.di

import com.example.data.JokeApi
import com.example.data.repository.JokeRepositoryImpl
import com.example.domain.repository.JokeRepository
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
