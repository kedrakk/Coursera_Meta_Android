package com.app.basiclist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.app.basiclist.ui.theme.BasicListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicListTheme {
                TestListAndGridApp()
            }
        }
    }
}

@Composable
fun TestListAndGridApp() {
    GridWidget()
}