package com.ostdan.car_selection.presentation.screens.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.presentation.components.CardView
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.Grey60

@Composable
fun StepGroupCard(
    modifier: Modifier = Modifier,
) {
    CardView(
        color = MaterialTheme.colorScheme.surface,
    ) {
        Box (
            modifier = Modifier
                .padding(5.dp)
                .widthIn(min = 100.dp, max = 100.dp)
                .heightIn(min = 100.dp)
        ) {
            Icon(
                Icons.Filled.Warning,
                tint = MaterialTheme.colorScheme.error,
                contentDescription = "Возникла проблема",
                modifier = Modifier.align(Alignment.TopEnd))
            Text(
                text = "Подкапотное пространство",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Grey60,
                softWrap = true,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

    }
}

@Preview(showBackground = false)
@Composable
fun StepGroupCardPreview() {
    CarselectionTheme {
        StepGroupCard()
    }
}
