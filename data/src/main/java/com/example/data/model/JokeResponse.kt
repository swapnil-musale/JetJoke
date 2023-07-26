package com.example.data.model

import com.squareup.moshi.Json

data class JokeResponse(

    @field:Json(name = "delivery")
    val delivery: String? = null,

    @field:Json(name = "safe")
    val safe: Boolean? = null,

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
)
