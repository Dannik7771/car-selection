package com.ostdan.car_selection.presentation.screens.main.elements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.ostdan.car_selection.domain.model.CheckGroupDTO
import com.ostdan.car_selection.presentation.components.CardView
import com.ostdan.car_selection.ui.theme.DefaultShadow
import com.ostdan.car_selection.ui.theme.Grey60

@Composable
fun CheckGroupCard(
    modifier: Modifier = Modifier,
    checkGroupDTO: CheckGroupDTO
) {
    CardView(
        color = MaterialTheme.colorScheme.surface
    ) {
        TextButton (
            modifier = Modifier
                .padding(5.dp)
                .widthIn(min = 100.dp, max = 100.dp)
                .heightIn(min = 100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(10.dp),
            onClick = {/*TODO: Add NavController*/}
        ) {
            /*Icon(
                Icons.Filled.Warning,
                tint = MaterialTheme.colorScheme.error,
                contentDescription = "Возникла проблема",
                modifier = Modifier.align(Alignment.TopEnd))*/
            Text(
                text = checkGroupDTO.name,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Grey60,
                //softWrap = true,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }

    }
}
