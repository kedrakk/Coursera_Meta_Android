package com.app.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.app.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                androidx.compose.material.Surface() {
                    RestaurantName(
                        name = stringResource(id = R.string.littlelemon),
                        fontSize = 18
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantName(name: String, fontSize: Int) {
    Text(text = name, fontSize = fontSize.sp, color = Color(0xFFD5d5d5))
}

@Preview(showBackground = true,)
@Composable
fun DefaultPreview() {
    BasicComposeTheme {
        RestaurantName(
            name = stringResource(id = R.string.littlelemon),
            fontSize = 18,
        )
    }
}