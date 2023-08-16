package com.devx.jetjoke.navigation

sealed class ScreenRoute(val route: String) {
    object HomeScreen : ScreenRoute(route = "home")
}
