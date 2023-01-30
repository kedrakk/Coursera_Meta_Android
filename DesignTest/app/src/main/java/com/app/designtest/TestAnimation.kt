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

fun main() {
    val numberMap = mapOf(
        5 to 6,
        3 to 2,
        8 to 7,
        4 to 1
    )
    val output = numberMap.map { entry ->
        entry.value
    }.filter {
        it > 3
    }.fold(2) { x, y ->
        x + y
    }
    println(output)
}