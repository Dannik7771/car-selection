package com.ostdan.car_selection.presentation.screens.checks.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.DangerColor

@Composable
fun WarningCard(descriptionWarning: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(DangerColor)
            .padding(PaddingValues(top = 5.dp, bottom = 5.dp, end = 10.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painterResource(R.drawable.ic_baseline_priority_high_24),
            contentDescription = "Предупреждение",
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = descriptionWarning,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Left,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WarningCardPreview() {
    CarselectionTheme {
        //WarningCard(it.descriptionWarning)
    }
}