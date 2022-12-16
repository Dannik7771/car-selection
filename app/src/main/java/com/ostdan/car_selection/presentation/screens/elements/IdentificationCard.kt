package com.ostdan.car_selection.presentation.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ostdan.car_selection.ui.theme.*

@Composable
fun IdentificationCard(
    modifier: Modifier = Modifier,
) {
    Column(Modifier.width(IntrinsicSize.Max)) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)))
        {
            TextField(
                modifier = Modifier
                    .background(Black)
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                value = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Grey,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    ) {
                        append("VIN  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = LightBlue95,
                            fontFamily = AnonymousPro,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp
                        )
                    ) {
                        append("_________________")
                    }
                },
                onValueChange = { value = it },
            ),
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
                .background(White)
                .border( width = 1.dp,
                    color = Grey90,
                    shape = RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp)))
        {
            Text(
                modifier = Modifier.align(Center),
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 36.sp
                    )) {
                        append("О")
                    }
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 46.sp
                    )) {
                        append("000")
                    }
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 36.sp
                    )) {
                        append("ОО")
                    }
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 30.sp
                    )) {
                        append("000")
                    }
                }
        )}
    }
}

@Preview(showBackground = false)
@Composable
fun IdentificationCardPreview() {
    CarselectionTheme {
        IdentificationCard()
    }
}
