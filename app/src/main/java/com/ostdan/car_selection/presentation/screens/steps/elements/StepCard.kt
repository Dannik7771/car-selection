package com.ostdan.car_selection.presentation.screens.steps.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ostdan.car_selection.presentation.components.CardView
import com.ostdan.car_selection.presentation.components.WarningIcon
import com.ostdan.car_selection.presentation.screens.checkpoints.elements.CheckpointCard
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@Composable
fun StepCard() {
    CardView(color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .clickable { /* обработчик клика */ }
            .padding(10.dp)
            .fillMaxWidth()) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(modifier = Modifier
                .padding(10.dp, 0.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                WarningIcon()
                Text(
                    text = "Сорванная резьба",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .weight(1f)
                        .padding(0.dp, 3.dp, 0.dp, 0.dp)
                )
                AddPhotoButton()
            }
            Text(
                text = "Сорванная резьба присутствует на элементах, которые нередко снимались для ремонта, замены и т.п.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 19.sp,
                modifier = Modifier.padding(10.dp,12.dp,10.dp,0.dp)
            )
            VINWidget(modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = "Присутствует ли сорванная резьба на дверных петлях?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 19.sp,
                modifier = Modifier.padding(10.dp,0.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun StepCardPreview() {
    CarselectionTheme {
        StepCard()
    }
}