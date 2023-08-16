package com.devx.jetjoke.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devx.domain.useCase.GetJokeUseCase
import com.devx.jetjoke.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getJokeUseCase: GetJokeUseCase,
    private val dispatchersProvider: DispatchersProvider,
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeScreenState> =
        MutableStateFlow(value = HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    init {
        fetchJoke()
    }

    fun fetchJoke() {
        viewModelScope.launch(context = dispatchersProvider.io) {
            _uiState.update {
                it.copy(isLoading = true)
            }
            val response = getJokeUseCase()
            if (response.error?.not() == true) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        jokeData = response,
                    )
                }
            }
        }
    }
}
