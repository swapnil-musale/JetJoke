package com.devx.data.mapper

import com.devx.data.model.JokeResponse

fun JokeResponse?.toDto(): com.devx.domain.model.JokeResponse {
    return com.devx.domain.model.JokeResponse(
        error = this?.error ?: true,
        type = this?.type ?: "",
        setUp = this?.setup ?: "",
        delivery = this?.delivery ?: "",
        category = this?.category ?: "",
        message = this?.message ?: "",
        joke = this?.joke ?: "",
    )
}
