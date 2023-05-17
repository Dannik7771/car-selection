package com.ostdan.car_selection.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.screens.main.elements.CheckGroupCard
import com.ostdan.car_selection.presentation.screens.main.elements.IdentificationCard
import com.ostdan.car_selection.presentation.screens.main.elements.LegalVerificationCard
import com.ostdan.car_selection.presentation.screens.steps.elements.AnimatedAnswerButton
import com.ostdan.car_selection.ui.theme.Black
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.White

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
   /* navController: NavHostController,*/
    viewModel: MainViewModel = hiltViewModel())
{
    val viewState by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(17.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
                Row {
                    IdentificationCard()
                    Icon(
                        painterResource(R.drawable.ic_baseline_question_mark_24),
                        contentDescription = "Вопрос",
                        tint = White,
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .padding(13.dp, 13.dp, 0.dp, 13.dp)
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Black)
                    )
                }
            LegalVerificationCard()
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            viewState.checkSession?.let {
                items(it.types) { type ->
                    Text(
                        text = type.type,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(0.dp, 8.dp)
                    )
                    FlowRow(
                        Modifier
                            .fillMaxWidth(1f)
                            .wrapContentHeight(align = Alignment.Top),
                        horizontalArrangement = Arrangement.spacedBy(15.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        content = {
                            type.checkGroups.forEachIndexed { _, checkGroup ->
                                CheckGroupCard(checkGroupDTO = checkGroup)
                            }
                        })
                    /*LazyVerticalGrid(columns = GridCells.Adaptive(100.dp)) {
                    items(checkGroupPreview.checkGroupList) { checkGroupPreview ->
                        CheckGroupCard(checkGroupDTO = checkGroupPreview)
                    }
                }*/
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CarselectionTheme {
        MainScreen()
    }
}