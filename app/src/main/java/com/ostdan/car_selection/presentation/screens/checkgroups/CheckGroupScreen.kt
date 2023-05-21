package com.ostdan.car_selection.presentation.screens.checkgroups

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.screens.checkgroups.elements.CheckCard
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.Inter

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CheckGroupScreen(
    viewModel: CheckGroupViewModel = hiltViewModel(),
    onNavigateToCheckScreen: (Any?) -> Unit
) {
    val viewState by viewModel.state.collectAsState()
    LaunchedEffect(true) {
        viewModel.fetchCheckGroup()
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        viewState.checkGroup?.let {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier
                        .padding(10.dp, 0.dp),
                    verticalArrangement = Arrangement.spacedBy((-22).dp)
                ) {
                    Text(
                        text = "ВЫПОЛНЕНО НА",
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = String.format("%.1f%%", it.completion * 100),//In percents
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.Bold,
                            fontSize = 64.sp,
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.mock),
                    contentDescription = stringResource(id = R.string.mock),
                )
            }
            LazyColumn(
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(it.categories) { category ->
                    Text(
                        text = category.category,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(
                            PaddingValues(start = 10.dp, end = 10.dp, bottom = 10.dp)
                        )
                    )
                    FlowColumn(
                        content = {
                            category.checks.forEachIndexed { _, check ->
                                CheckCard(check, onNavigateToCheckScreen)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckpointsScreenPreview() {
    CarselectionTheme {
        //CheckGroupScreen()
    }
}
