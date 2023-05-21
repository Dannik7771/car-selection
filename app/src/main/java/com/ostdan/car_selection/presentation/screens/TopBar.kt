package com.ostdan.car_selection.presentation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.ostdan.car_selection.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController) {
    val showBackButton = remember { mutableStateOf(false) }

    navController.addOnDestinationChangedListener { _, _, _ ->
        showBackButton.value = navController.previousBackStackEntry != null
    }

    TopAppBar(
        title = { Text("Подбор авто") },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        navigationIcon = {
            if (showBackButton.value) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_arrow_back_ios_new_24),
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}