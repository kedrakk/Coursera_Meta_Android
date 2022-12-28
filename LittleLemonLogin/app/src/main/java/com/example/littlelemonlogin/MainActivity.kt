package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LittleLemonLogin()
                }
            }
        }
    }
}

@Composable
fun LittleLemonLogin() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = stringResource(
                id = R.string.logoimage
            ),
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.username)) },
        )
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = stringResource(id = R.string.password)) },
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.background(color = Color(0X7f495E57)),
        ) {
            Text(text = stringResource(id = R.string.login), color = Color(0X7fEDEFEE))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    LittleLemonLogin()
}