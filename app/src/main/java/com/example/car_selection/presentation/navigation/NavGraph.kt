package com.example.car_selection.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.car_selection.presentation.screens.main.MainScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    paddings: PaddingValues,
    setFabOnClick: (() -> Unit) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
    ) {
        composable(route = Screen.Main.route) {
            MainScreen(/*navController = navController, paddings, setFabOnClick*/)
        }
        composable(route = Screen.Checkpoints.route) {
            //SettingsScreen( paddings)
        }
    }
}