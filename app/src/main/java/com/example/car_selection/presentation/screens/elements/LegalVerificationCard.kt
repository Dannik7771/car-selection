package com.example.car_selection.presentation.screens.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.car_selection.presentation.components.CardView
import com.example.car_selection.ui.theme.Blue50
import com.example.car_selection.ui.theme.Blue70
import com.example.car_selection.ui.theme.CarselectionTheme
import com.example.car_selection.ui.theme.White

@Composable
fun LegalVerificationCard(
    modifier: Modifier = Modifier,
) {
    CardView(
        brush = Brush.horizontalGradient(
            colors = listOf(
            Blue50,
            Blue70
        )),
        modifier = Modifier.padding(15.dp, 8.dp)
    )
    {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier.padding(0.dp,0.dp,20.dp,0.dp)
                    ) {
                Text(
                    text = "Юрид. проверка готова",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "проблем не обнаружено",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = White,
                    contentColor = MaterialTheme.colorScheme.primary)) {
                Text(text = "Смотреть",
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun LegalVerificationCardPreview() {
    CarselectionTheme {
        LegalVerificationCard()
    }
}

