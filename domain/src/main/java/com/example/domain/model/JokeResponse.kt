package com.example.domain.model

data class JokeResponse(
    val error: Boolean? = false,
    val type: String,
    val setUp: String,
    val delivery: String,
    val category: String,
    val message: String? = null,
)
