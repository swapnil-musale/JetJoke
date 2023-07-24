package com.example.data.model

import com.squareup.moshi.Json

data class JokeResponse(

    @Json(name = "delivery")
    val delivery: String? = null,

    @Json(name = "safe")
    val safe: Boolean? = null,

    @Json(name = "setup")
    val setup: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "error")
    val error: Boolean? = null,

    @Json(name = "category")
    val category: String? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "lang")
    val lang: String? = null,

    @Json(name = "message")
    val message: String? = null,
)
