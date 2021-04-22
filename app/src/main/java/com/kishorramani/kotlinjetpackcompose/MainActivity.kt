package com.kishorramani.kotlinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutData()
        }
    }
}

@Composable
fun ConstraintLayoutData() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenbox")
        val redBox = createRefFor("redbox")

        val middleGuideline = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            // top.linkTo(parent.top)
            top.linkTo(middleGuideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            // top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            bottom.linkTo(middleGuideline)
            // end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            // width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }

        // createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.SpreadInside)
        createVerticalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redbox")
        )
    }
}

@Preview
@Composable
fun PreviewConstraintLayout() {
    ConstraintLayoutData()
}
