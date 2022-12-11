package com.example.car_selection.presentation.screens.elements

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.car_selection.ui.theme.CarselectionTheme

@Composable
fun CheckGroupPreviewCard(
    modifier: Modifier = Modifier,
) {
    Text(text = "Проверка номеров")
    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {

    }
}

@Preview(showBackground = false)
@Composable
fun CheckGroupPreviewCardPreview() {
    CarselectionTheme {
        CheckGroupPreviewCard()
    }
}
