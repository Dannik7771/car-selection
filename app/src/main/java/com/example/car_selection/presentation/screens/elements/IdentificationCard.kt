package com.example.car_selection.presentation.screens.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_selection.presentation.components.CardView
import com.example.car_selection.ui.theme.*

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
            Text(
                modifier = Modifier
                    .background(Black)
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Grey,
                            fontFamily = Poppins,
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
                        append("XTA210530 5203 ****")
                    }
                })
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(0.dp, 0.dp, 10.dp, 10.dp))
                .background(White)
                .border( width = 1.dp,
                    color = LightGray,
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
                        append("B")
                    }
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 46.sp
                    )) {
                        append("004")
                    }
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 36.sp
                    )) {
                        append("KO")
                    }
                    withStyle(style = SpanStyle(
                        color = Black,
                        fontFamily = Ubuntu,
                        fontSize = 30.sp
                    )) {
                        append("777")
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
