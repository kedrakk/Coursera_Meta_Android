package com.app.designtest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun TestAnimationWidget() {
    var visible by remember {
        mutableStateOf(false)
    }

    Column() {
        AnimatedVisibility(visible = visible, enter = fadeIn(), exit = fadeOut()) {
            Text(text = "Hello, World!")
        }
        Button(onClick = { visible = !visible }) {
            Text(text = "Button")
        }
    }
}