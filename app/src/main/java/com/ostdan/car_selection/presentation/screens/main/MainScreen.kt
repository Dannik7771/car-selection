package com.ostdan.car_selection.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ostdan.car_selection.R
import com.ostdan.car_selection.presentation.screens.elements.IdentificationCard
import com.ostdan.car_selection.presentation.screens.elements.LegalVerificationCard
import com.ostdan.car_selection.ui.theme.Black
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.White

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
   /* navController: NavHostController,
    padding: PaddingValues,*/
    /*viewModel: MainViewModel = hiltViewModel()*/)
{
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(17.dp),
        modifier = Modifier.padding(10.dp).fillMaxWidth()) {
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
        item { LegalVerificationCard()}
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CarselectionTheme {
        MainScreen()
    }
}