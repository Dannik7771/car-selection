package com.ostdan.car_selection.presentation.screens.checks.elements

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.SmallPrimaryButtonColor

@Composable
fun AnimatedAnswerButton(
    question: CheckDTO.StepDTO.QuestionDTO,
    answer: CheckDTO.StepDTO.QuestionDTO.AnswerDTO
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .clickable { expanded = !expanded }) {
        AnimatedContent(
            targetState = expanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) with
                        fadeOut(animationSpec = tween(150)) using
                        SizeTransform { initialSize, targetSize ->
                            if (targetState) {
                                keyframes {
                                    // Expand horizontally first.
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            } else {
                                keyframes {
                                    // Shrink horizontally first.
                                    IntSize(targetSize.width, initialSize.height) at 150
                                    durationMillis = 300
                                }
                            }
                        }
            }
        ) { targetExpanded ->
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
                        /*Icon(
                                painterResource(R.drawable.ic_baseline_check_24),
                                tint = MaterialTheme.colorScheme.onSurface,
                                contentDescription = "Ответить положительно",
                                modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)
                            )*/
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
                        /*Icon(
                                painterResource(R.drawable.ic_baseline_redo_24),
                                tint = MaterialTheme.colorScheme.onSurface,
                                contentDescription = "Переделать"
                                modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)
                            )*/
                    }
                }
                else -> { //Выбран не этот ответ

                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AnimatedButtonPreview() {
    CarselectionTheme {
        //AnimatedAnswerButton()
    }
}
