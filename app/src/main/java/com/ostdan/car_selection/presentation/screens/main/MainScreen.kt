package com.ostdan.car_selection.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.screens.main.elements.CheckGroupCard
import com.ostdan.car_selection.presentation.screens.main.elements.IdentificationCard
import com.ostdan.car_selection.presentation.screens.main.elements.LegalVerificationCard
import com.ostdan.car_selection.ui.theme.Black
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.White

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
   /* navController: NavHostController,
    padding: PaddingValues,*/
    viewModel: MainViewModel = hiltViewModel())
{
    val viewState by viewModel.state.collectAsState()

    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(17.dp),
            modifier = Modifier
                .fillMaxWidth()) {
            item { Row {
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
                        .background(Black))
            }}
            item { LegalVerificationCard() }
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            viewState.checkSession?.let {
                items(it.checkGroupPreviewList) { checkGroupPreview ->
                    Text(text = checkGroupPreview.type,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(0.dp, 2.dp)
                    )
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        mainAxisSize = SizeMode.Expand,
                        mainAxisAlignment = FlowMainAxisAlignment.Start,
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp
                    ) {
                        checkGroupPreview.checkGroupList.forEachIndexed { _, checkGroup ->
                            CheckGroupCard(checkGroupDTO = checkGroup)
                        }
                    }
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