package com.ostdan.car_selection.presentation.screens.checks.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.R
import com.ostdan.car_selection.ui.theme.CarselectionTheme
import com.ostdan.car_selection.ui.theme.SmallSecondaryButtonColor

@Composable
fun AddPhotoButton(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable {  }
            .background(SmallSecondaryButtonColor)
            .padding(6.dp)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically)
    {
        Icon(
            painterResource(R.drawable.ic_baseline_photo_camera_24),
            tint = MaterialTheme.colorScheme.onSurface,
            contentDescription = "Добавить фото (камера)")
        Icon(
            painterResource(R.drawable.ic_baseline_add_24),
            tint = MaterialTheme.colorScheme.onSurface,
            contentDescription = "Добавить фото (плюс)")
    }
}

@Preview(showBackground = true)
@Composable
fun AddPhotoButtonPreview() {
    CarselectionTheme {
        AddPhotoButton()
    }
}
