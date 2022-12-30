package com.app.basicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.basicnavigation.ui.theme.BasicNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    BasicNavigationApp()
                }
            }
        }
    }
}

@Composable
fun BasicNavigationApp() {
    MyNavigation()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicNavigationTheme {
        BasicNavigationApp()
    }
}