package com.kishorramani.kotlinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnData()
        }
    }
}

@Composable
fun ColumnData() {
    Column(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxHeight(0.5f)
            .width(600.dp)                  //If width is more than screen height then it's scratch to max width of screen means fillMaxWidth
            // .requiredWidth(600.dp)       //It's scratch the layout to out of screen
            .padding(top = 10.dp, start = 50.dp)
            .border(5.dp, Color.Magenta)
            .padding(5.dp)
            .border(5.dp, Color.Blue)
            .padding(5.dp)
            .border(10.dp, Color.Black)
            .padding(10.dp)
    ) {
        Text(
            "Android",
            modifier = Modifier
                .offset(50.dp, 50.dp)
                .border(5.dp, Color.Cyan)
                .padding(5.dp)
                .offset(50.dp, 0.dp)
                .border(15.dp, Color.LightGray)
                .padding(15.dp)
                .clickable {
                }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text("Jetpack")
        Text("Compose")
    }
}

@Preview
@Composable
fun PreviewColumnData() {
    ColumnData()
}