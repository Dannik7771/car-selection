package com.ostdan.car_selection.presentation.screens.checkpoints.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.components.CardView
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.ImageBackColor

@Composable
fun CheckpointCard() {
    CardView(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .clickable { /* обработчик клика */ }
            .padding(5.dp, 10.dp)
            .heightIn(min = 55.dp, max = 55.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()) {
            Box(Modifier
                .weight(2f)
                .clip(RoundedCornerShape(10.dp))
                .background(ImageBackColor))
            {
                Image(
                    painter = painterResource(id = R.drawable.mock),
                    contentDescription = stringResource(id = R.string.mock),
                    Modifier
                        .align(Alignment.Center)
                        .padding(4.dp)
                )
            }
            Column(Modifier.weight(4f)) {
                Text(
                    text = "Крепление дверей",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "в процессе выполнения",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Icon(painterResource(R.drawable.ic_baseline_navigate_next_24),
                contentDescription = "Перейти",
                Modifier.weight(0.5f))
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CheckpointCardPreview() {
    CarselectionTheme {
        CheckpointCard()
    }
}
