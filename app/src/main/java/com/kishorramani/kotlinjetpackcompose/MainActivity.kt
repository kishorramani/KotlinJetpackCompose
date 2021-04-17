package com.kishorramani.kotlinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kishorramani.kotlinjetpackcompose.ui.theme.KotlinJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColumnData()
            RowData()
        }
    }

    @Composable
    fun ColumnData() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Kotlin")
            Text("Jetpack")
            Text("Compose")
        }
    }

    @Preview
    @Composable
    fun ColumnDataPreview() {
        ColumnData()
    }

    @Composable
    fun RowData() {
        Row(
            //day2-1
            /*modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .background(Color.Magenta),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround*/

            //day2-2
            modifier = Modifier
                .fillMaxSize(0.5f)
                .background(Color.Green),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("Kotlin")
            Text("Jetpack")
            Text("Compose")
        }
    }

    @Preview
    @Composable
    fun RowDataPreview() {
        RowData()
    }
}