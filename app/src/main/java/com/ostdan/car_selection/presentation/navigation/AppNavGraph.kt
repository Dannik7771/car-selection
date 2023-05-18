package com.ostdan.car_selection.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ostdan.car_selection.presentation.screens.Screens
import com.ostdan.car_selection.presentation.screens.checkgroups.CheckGroupScreen
import com.ostdan.car_selection.presentation.screens.main.MainScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        Modifier.padding(paddingValues)
    ) {
        composable(route = Screens.Main.name) {
            MainScreen {
                navController.navigate(Screens.CheckGroups.name)
            }
        }
        composable(route = Screens.CheckGroups.name) {
            CheckGroupScreen(

            )
        }
    }
}