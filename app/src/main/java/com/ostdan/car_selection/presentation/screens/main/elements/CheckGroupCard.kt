package com.ostdan.car_selection.presentation.screens.main.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ostdan.car_selection.R
import com.ostdan.car_selection.domain.model.CheckSessionDTO
import com.ostdan.car_selection.presentation.components.CardView
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.DarkBlue36

@Composable
fun CheckGroupCard(
    modifier: Modifier = Modifier,
    checkGroupDTO: CheckSessionDTO.TypeDTO.CheckGroupDTO,
    onNavigateToCheckGroupScreen: (Any?) -> Unit
) {
    CardView(
        color = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .clickable(onClick = { onNavigateToCheckGroupScreen(checkGroupDTO.checkGroupId)} )
            .padding(5.dp)
            .widthIn(min = 100.dp, max = 100.dp)
            .heightIn(min = 100.dp, max = 100.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            AsyncImage(
                model = stringResource(R.string.url_image_mock),
                contentDescription = stringResource(id = R.string.mock),
                modifier = Modifier.weight(2f)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = checkGroupDTO.name,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    color = DarkBlue36,
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CheckGroupCardPreview() {
    CarselectionTheme {
        //CheckGroupCard()
    }
}

