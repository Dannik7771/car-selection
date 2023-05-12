package com.ostdan.car_selection.presentation.screens.steps.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ostdan.car_selection.ui.theme.*

@Composable
fun VINWidget(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Black)
            .padding(8.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically)
    {
        Text(
            text = "VIN  ",
            style = TextStyle(
                color = Grey,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
        Text(
            text = "XWFGB6EC1 B000 1174",
            maxLines = 1,
            style = TextStyle(
                color = LightBlue95,
                fontFamily = AnonymousPro,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            modifier = Modifier.defaultMinSize(minWidth = 200.dp)
        )
    }
}


@Preview(showBackground = false)
@Composable
fun VINWidgetPreview() {
    CarselectionTheme {
        VINWidget()
    }
}