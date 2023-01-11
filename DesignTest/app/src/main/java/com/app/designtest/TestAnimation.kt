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

data class OrderItem(val name: String, val price: Double)

class TaxCalculator {
    companion object {
        private const val salesTaxPercentage: Double = 9.5
        fun getTaxAmountForOrderItems(orderItems: List<OrderItem>): Double {
            var orderAmount = 0.0
            for (i in orderItems.indices) {
                orderAmount += orderItems[i].price
            }
            return orderAmount * salesTaxPercentage / 100.00
        }
    }
}

fun main() {
   var orderItemList= listOf(
       OrderItem(name = "Burger", price = 8.00),
       OrderItem(name = "Fries", price = 4.00),
       OrderItem(name = "Soda", price = 2.00),
       OrderItem(name = "Ice Cream", price = 4.00),
   )
    val res=TaxCalculator.getTaxAmountForOrderItems(orderItemList)
    println(res)
}