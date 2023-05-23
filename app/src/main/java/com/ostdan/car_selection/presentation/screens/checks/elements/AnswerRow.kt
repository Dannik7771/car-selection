package com.ostdan.car_selection.presentation.screens.checks.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AnswerRow(stepId: String, question: CheckDTO.StepDTO.QuestionDTO) {
    FlowRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            question.answers.forEachIndexed { _, answer ->
                AnimatedAnswerButton(stepId = stepId, question = question, answer = answer)
            }
        }
    )
}

@Preview(showBackground = false)
@Composable
fun AnswerRowPreview() {
    CarselectionTheme {
        //AnswerRow()
    }
}
