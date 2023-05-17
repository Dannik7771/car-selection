package com.ostdan.car_selection.presentation.screens.steps.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@Composable
fun AnswerRow(stepAnswer: StepAnswer) {
    Row(modifier = Modifier.fillMaxWidth()) {
        //AnimatedAnswerButton()
        //AnimatedAnswerButton()
    }
}

data class StepAnswer(val answerId: String?,
                 val answered: Boolean = false)

@Preview(showBackground = false)
@Composable
fun AnswerRowPreview() {
    CarselectionTheme {
        //AnswerRow()
    }
}
