package com.devx.jetjoke.navigation

sealed class ScreenRoute(
    val route: String,
) {
    data object HomeScreen : ScreenRoute(route = "home")
}
