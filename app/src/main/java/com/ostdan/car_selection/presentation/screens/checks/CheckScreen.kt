package com.ostdan.car_selection.presentation.screens.checks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.screens.checks.elements.AlertCard
import com.ostdan.car_selection.presentation.screens.checks.elements.StepCard
import com.ostdan.car_selection.presentation.screens.checks.elements.WarningCard
import com.ostdan.car_selection.ui.theme.CarselectionTheme

@Composable
fun CheckScreen(
    viewModel: CheckViewModel = hiltViewModel(),
) {
    val viewState by viewModel.state.collectAsState()
    LaunchedEffect(true) {
        viewModel.fetchCheck()
    }

    Column(
    ) {
        viewState.check?.let {
        Column(
            modifier = Modifier
                .padding(20.dp, 10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            if (it.descriptionAlert.isNotEmpty())
                AlertCard(it.descriptionAlert)
            if (it.descriptionWarning.isNotEmpty())
                WarningCard(it.descriptionWarning)
            Text(
                text = it.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.onSurface
            )
            /*Async*/Image(
            painter = painterResource(id = R.drawable.mock),
            /*model = stringResource(R.string.url_image_mock),*/
            contentDescription = stringResource(id = R.string.mock)
            )
                Text(
                    text = "Проверьте следующие пункты:",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.onSurface
                )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(it.steps){ step ->
                    StepCard(step)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckScreenPreview() {
    CarselectionTheme {
        CheckScreen()
    }
}