package com.ostdan.car_selection.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ostdan.car_selection.presentation.navigation.AppNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { TopBar() },
        containerColor = MaterialTheme.colorScheme.background,
        content = {
            paddingValues -> AppNavGraph(
            navController = navController,
            startDestination = Screens.Main.name,
            paddingValues)
        }
    )
}