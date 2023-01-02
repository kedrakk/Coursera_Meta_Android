package com.app.basiclist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GridWidget() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        repeat(10){
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                repeat(2){
                    GridCellWidget()
                }
            }
        }
    }
}

@Composable
fun GridCellWidget() {
    Card(
        elevation = 16.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredSize(180.dp, 180.dp)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek Salad"
            )
            Text(
                text = "Greek Salad",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(Color.White)
                    .align(
                        Alignment.TopStart
                    ),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "$12.99",
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.White)
                    .align(
                        Alignment.BottomEnd
                    ),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridWidgetPreview() {
    GridWidget()
}