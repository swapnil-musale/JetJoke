package com.devx.data.util.networkUtil

import com.devx.domain.util.Mapper
import com.devx.domain.util.NetworkResponse
import retrofit2.HttpException
import retrofit2.Response

suspend fun <R : Mapper<T>, T : Any> safeApiCall(execute: suspend () -> Response<R>): NetworkResponse<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResponse.Success(data = body.mapToDomain())
        } else {
            NetworkResponse.Error(errorMessage = response.message())
        }
    } catch (exception: HttpException) {
        NetworkResponse.Error(errorMessage = exception.localizedMessage)
    } catch (throwable: Throwable) {
        NetworkResponse.Exception(throwable = throwable)
    }
}
