package com.devx.data.model

import androidx.annotation.Keep
import com.devx.domain.model.JokeResponse
import com.devx.domain.util.Mapper
import com.squareup.moshi.Json

@Keep
data class JokeResponseDto(

    @field:Json(name = "delivery")
    val delivery: String? = null,

    @field:Json(name = "safe")
    val safe: Boolean? = null,

    @field:Json(name = "joke")
    val joke: String? = null,

    @field:Json(name = "setup")
    val setup: String? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "error")
    val error: Boolean? = null,

    @field:Json(name = "category")
    val category: String? = null,

    @field:Json(name = "type")
    val type: String? = null,

    @field:Json(name = "lang")
    val lang: String? = null,

    @field:Json(name = "message")
    val message: String? = null,
) : Mapper<JokeResponse> {
    override fun mapToDomain(): JokeResponse {
        return JokeResponse(
            error = error ?: false,
            type = type.orEmpty(),
            setUp = setup,
            joke = joke,
            delivery = delivery,
            category = category.orEmpty(),
            message = message,
        )
    }
}
