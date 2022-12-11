package com.example.car_selection.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Main : Screen("main_screen", "Подбор авто", Icons.Default.Home )
    object Checkpoints : Screen("checkpoints_screen", "Пункты проверки", Icons.Default.Settings )
}
