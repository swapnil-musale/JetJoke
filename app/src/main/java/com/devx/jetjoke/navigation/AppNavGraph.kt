package com.devx.jetjoke.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devx.jetjoke.ui.actions.AppActions
import com.devx.jetjoke.ui.home.HomeScreen
import com.devx.jetjoke.ui.home.HomeViewModel

@Composable
fun AppNavGraph(action : (AppActions)-> Unit) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.HomeScreen.route,
    ) {
        composable(route = ScreenRoute.HomeScreen.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()

            HomeScreen(
                uiState = uiState.value,
                loadNextJoke = {
                    homeViewModel.fetchJoke()
                },
                action = action,
            )
        }
    }
}
