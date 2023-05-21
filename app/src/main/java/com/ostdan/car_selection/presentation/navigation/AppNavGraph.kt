package com.ostdan.car_selection.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ostdan.car_selection.presentation.screens.Screens
import com.ostdan.car_selection.presentation.screens.checkgroups.CheckGroupScreen
import com.ostdan.car_selection.presentation.screens.checks.CheckScreen
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
        composable(route = Screens.Main.route) {
            MainScreen { userId ->
                navController.navigate("checkGroup/$userId")
            }
        }
        composable(route = "checkGroup/{checkGroupId}",
            arguments = listOf(navArgument("checkGroupId") { type = NavType.StringType })) {
            CheckGroupScreen { checkId ->
                navController.navigate("check/$checkId")
            }
        }
        composable(route = "check/{checkId}",
            arguments = listOf(navArgument("checkId") { type = NavType.StringType })) {
            CheckScreen(

            )
        }
    }
}