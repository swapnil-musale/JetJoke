package com.example.jetjoke.di

import com.example.jetjoke.util.CoroutineDispatchers
import com.example.jetjoke.util.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DispatcherModule {

    @Provides
    fun provideDispatcher(): DispatchersProvider {
        return CoroutineDispatchers()
    }
}
