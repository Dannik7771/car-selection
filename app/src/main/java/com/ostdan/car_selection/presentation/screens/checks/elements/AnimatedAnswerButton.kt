package com.ostdan.car_selection.presentation.screens.checks.elements

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.presentation.screens.checks.CheckViewModel
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.SmallPrimaryButtonColor

@Composable
fun AnimatedAnswerButton(
    viewModel: CheckViewModel = hiltViewModel(),
    stepId: String,
    question: CheckDTO.StepDTO.QuestionDTO,
    answer: CheckDTO.StepDTO.QuestionDTO.AnswerDTO
) {
    var expanded by remember { mutableStateOf(question.selectedAnswerId == answer.answerId) }
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            expanded = !expanded
            onAnswerClicked(viewModel, stepId, answer.answerId, expanded)
        }
        .animateContentSize()
    )
    {
            when (question.selectedAnswerId) {
                null -> { //Ответ не выбран
                    Row(
                        modifier = Modifier
                            .background(SmallPrimaryButtonColor)
                            .padding(10.dp, 5.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = answer.text,
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Left,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                answer.answerId -> { //Этот ответ выбран
                    Row(
                        modifier = Modifier
                            .background(SmallPrimaryButtonColor)
                            .fillMaxWidth()
                            .padding(10.dp, 5.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = answer.textWhenSelected,
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Left,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                else -> { //Выбран не этот ответ

                }
            }
    }
}

fun onAnswerClicked(viewModel: CheckViewModel, stepId: String, answerId: String, expanded: Boolean) {
    viewModel.updateAnswer(stepId, answerId, expanded)
}

@Preview(showBackground = false)
@Composable
fun AnimatedButtonPreview() {
    CarselectionTheme {
        //AnimatedAnswerButton()
    }
}
