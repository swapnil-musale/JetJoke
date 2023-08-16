package com.devx.jetjoke.di

import com.devx.domain.useCase.GetJokeUseCase
import com.devx.jetjoke.ui.home.HomeViewModel
import com.devx.jetjoke.util.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideJokeViewModel(
        getJokeUseCase: GetJokeUseCase,
        dispatchersProvider: DispatchersProvider,
    ): HomeViewModel {
        return HomeViewModel(
            getJokeUseCase = getJokeUseCase,
            dispatchersProvider = dispatchersProvider,
        )
    }
}
