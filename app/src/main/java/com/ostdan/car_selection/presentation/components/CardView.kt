package com.ostdan.car_selection.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostdan.car_selection.ui.theme.*


@Composable
fun CardView(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    color: Color = MaterialTheme.colorScheme.primary,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .widthIn(min = 20.dp)
            .shadow(
                elevation = 10.dp,
                shape = shape,
                spotColor = SpotColor
            )
            .background(color)
            .then(modifier))
        {
            content()
        }
}

@Composable
fun CardView(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    brush : Brush = Brush.linearGradient(listOf(Grey60, Grey90)),
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .widthIn(min = 20.dp)
            .shadow(
                elevation = 10.dp,
                shape = shape
            )
            .background(brush)
            .then(modifier))
    {
        content()
    }
}

/*@Composable
fun CardView(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    color: Color = MaterialTheme.colorScheme.primary,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .widthIn(min = 16.dp)
            .background(color, shape),
        content = content
    )
}*/

@Preview(showBackground = true)
@Composable
fun CardViewPreview() {
    CarselectionTheme {
        CardView(color = MaterialTheme.colorScheme.surface) {
            Text("Тут что-то написано")
        }
    }
}