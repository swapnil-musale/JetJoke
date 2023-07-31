package com.example.domain.model

data class JokeResponse(
    val error: Boolean? = false,
    val type: String,
    val setUp: String?,
    val joke: String?,
    val delivery: String?,
    val category: String,
    val message: String? = null,
)

fun getFakeJokeData(): JokeResponse {
    return JokeResponse(
        error = false,
        type = "twopart", // "single"
        setUp = "So what's a set of predefined steps the government might take to preserve the environment?",
        delivery = "An Al-Gore-ithm.",
        category = "Programming",
        joke = "",
        message = "",
    )
}
