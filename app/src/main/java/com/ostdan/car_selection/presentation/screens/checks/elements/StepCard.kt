package com.ostdan.car_selection.presentation.screens.checks.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.domain.model.CheckDTO
import com.ostdan.car_selection.domain.model.CheckDTO.StepDTO.StepTypeDTO
import com.ostdan.car_selection.presentation.components.CardView
import com.ostdan.car_selection.presentation.components.WarningIcon
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@Composable
fun StepCard(step: CheckDTO.StepDTO) {
    CardView(color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    WarningIcon()
                    Text(
                        text = step.title,
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Left,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .weight(1f)
                            .padding(0.dp, 3.dp, 0.dp, 0.dp)
                    )
                    AddPhotoButton()
                }
                if (step.descriptionWarning.isNotEmpty())
                    WarningStepCard(step.descriptionWarning)
                Text(
                    text = step.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 19.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                when (step.type) {
                    StepTypeDTO.Default -> {}
                    StepTypeDTO.VINCheck ->
                        step.additionalData?.let { VINWidget(step.additionalData) }
                    else -> {}
                }

                /*Async*/Image(
                painter = painterResource(id = R.drawable.mock),
                /*model = stringResource(R.string.url_image_mock),*/
                contentDescription = stringResource(id = R.string.mock))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = step.question.text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 19.sp
                )
                AnswerRow(step.question)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun StepCardPreview() {
    CarselectionTheme {
        //StepCard(step)
    }
}