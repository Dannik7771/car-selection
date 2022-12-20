package com.ostdan.car_selection.presentation.screens.main.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ostdan.car_selection.presentation.screens.main.MainViewModel
import com.ostdan.car_selection.ui.theme.*


@Composable
fun IdentificationCard(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    Column(Modifier.width(IntrinsicSize.Max)) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp))
                .background(Black)
                .padding(8.dp))
        {
            Text(
                text = "VIN  ",
                style = TextStyle(
                    color = Grey,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )

            BasicTextField(
                value = viewModel.vinFieldState,
                singleLine = true,
                maxLines = 1,
                onValueChange = { viewModel.updateTextFieldVIN(it) },
                textStyle = TextStyle(
                    color = LightBlue95,
                    fontFamily = AnonymousPro,
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { viewModel.fetchCheckSession() }
                ),
                modifier = Modifier.defaultMinSize(minWidth = 200.dp)
            )
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
