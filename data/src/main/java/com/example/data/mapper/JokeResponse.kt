package com.example.data.mapper

import com.example.data.model.JokeResponse

fun JokeResponse?.toDto(): com.example.domain.model.JokeResponse {
    return com.example.domain.model.JokeResponse(
        error = this?.error ?: true,
        type = this?.type ?: "",
        setUp = this?.setup ?: "",
        delivery = this?.delivery ?: "",
        category = this?.category ?: "",
        message = this?.message ?: "",
        joke = this?.joke ?: "",
    )
}
