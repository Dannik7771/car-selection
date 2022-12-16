package com.ostdan.car_selection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ostdan.car_selection.presentation.screens.main.MainScreen
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CarselectionTheme {
                MainScreen()
            }
        }
    }
}