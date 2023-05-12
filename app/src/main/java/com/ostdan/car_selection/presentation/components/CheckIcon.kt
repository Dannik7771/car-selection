package com.ostdan.car_selection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@Composable
fun CheckIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .padding(3.dp)
            .then(modifier))
    {
        Icon(
            painterResource(R.drawable.ic_baseline_check_24),
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = "Проверено"
        )
    }
}

@Preview(showBackground = false)
@Composable
fun OkayIconPreview() {
    CarselectionTheme {
        CheckIcon()
    }
}