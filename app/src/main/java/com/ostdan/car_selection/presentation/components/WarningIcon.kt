package com.ostdan.car_selection.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@Composable
fun WarningIcon(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    Pulsating {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(3.dp)
                .then(modifier))
        {
            Icon(
                painterResource(R.drawable.ic_baseline_priority_high_24),
                tint = MaterialTheme.colorScheme.onTertiary,
                contentDescription = "Предупреждение"
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun WarningIconPreview() {
    CarselectionTheme {
        WarningIcon()
    }
}