package com.example.jetjoke.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetjoke.ui.home.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HomeScreen.route,
    ) {
        composable(route = ScreenRoute.HomeScreen.route) {
            HomeScreen()
        }
    }
}
