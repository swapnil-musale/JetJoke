package com.devx.domain.util

sealed class NetworkResponse<T>(
    val data: T? = null,
    val errorMessage: String? = null,
    val exception: Throwable? = null,
) {
    class Success<T>(data: T) : NetworkResponse<T>(data = data)
    class Error<T>(errorMessage: String?) : NetworkResponse<T>(errorMessage = errorMessage)
    class Exception<T>(throwable: Throwable) : NetworkResponse<T>(exception = throwable)
}
