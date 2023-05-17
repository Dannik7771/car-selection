package com.ostdan.car_selection.presentation.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("Подбор авто") },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    )
}