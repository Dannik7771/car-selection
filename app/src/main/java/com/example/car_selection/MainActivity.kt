package com.example.car_selection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_selection.ui.theme.CarselectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val selected = remember { mutableStateOf(false) }
            CarselectionTheme {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "Почта",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Red)
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Hello!",
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                // A surface container using the 'background' color from the theme
                /*Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Здарова $name!",
        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .background(Color.Red)
            .padding(20.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CarselectionTheme {
        Greeting("бандиты")
    }
}