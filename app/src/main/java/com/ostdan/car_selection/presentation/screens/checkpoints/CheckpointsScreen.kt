package com.ostdan.car_selection.presentation.screens.checkpoints

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.screens.checkpoints.elements.CheckpointCard
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.Inter

@Composable
fun CheckpointsScreen() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Column(
                Modifier
                    .padding(10.dp, 0.dp),
                verticalArrangement = Arrangement.spacedBy((-22).dp)) {
                Text(
                    text = "ВЫПОЛНЕНО НА",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "66.6%",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = 64.sp,
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Image(
                painter = painterResource(id = R.drawable.mock),
                contentDescription = stringResource(id = R.string.mock),
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Категория",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(10.dp,0.dp)
            )
            CheckpointCard()
            CheckpointCard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckpointsScreenPreview() {
    CarselectionTheme {
        CheckpointsScreen()
    }
}
