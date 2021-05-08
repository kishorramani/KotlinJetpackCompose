package com.kishorramani.kotlinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // CounterApp()
            CounterApp1()
        }
    }
}

@Composable
fun CounterApp() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState) {
        var counter by remember {
            mutableStateOf(0)
        }
        if (counter % 5 == 0 && counter > 0) {
            /*scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Hey $counter is divisible by 5")
            }*/

            //Launch effect cancel the current snackbar effect if we click again fast means it's cancel coroutine and restart
            LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                scaffoldState.snackbarHostState.showSnackbar("Hey $counter is divisible by 5")
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { counter++ }
            ) {
                Text(text = "Click me $counter")
            }
        }
    }
}

@Composable
fun CounterApp1() {
    //it's use in network call
    //provide default value to some ui and update after getting reponse
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
        var counter = produceState(initialValue = 0) {
            kotlinx.coroutines.delay(4000)
            value = 5
        }

        if (counter.value % 5 == 0 && counter.value > 0) {
            //Launch effect cancel the current snackbar effect if we click again fast means it's cancel coroutine and restart
            LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                scaffoldState.snackbarHostState.showSnackbar("Hey ${counter.value} is divisible by 5")
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { }
            ) {
                Text(text = "Click me ${counter.value}")
            }
        }
    }
}

var i = 0
@Composable
fun MyComposable(backPressedDispatcher: OnBackPressedDispatcher) {
    //This is called when composing finish successful
    /*SideEffect {
        i++
    }*/

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //do something
            }
        }
    }

    //use to free some resources
    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }

    Button(onClick = { /*TODO*/ }) {
        Text(text = "Click me")
    }
}