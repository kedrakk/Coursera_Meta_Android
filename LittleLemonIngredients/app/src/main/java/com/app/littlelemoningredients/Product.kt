package com.app.littlelemoningredients

import kotlin.random.Random

data class Product(
    val title: String,
    var price: Double,
    var amount: Int
) {

    fun applyDiscount(discountPercent: Int) {
        if (amount in 1..10) {
            price -= (price * discountPercent / 100)
        }
    }
}

fun spin( spinTimes:Int){
    var maximumDiscountValue = 0;
    repeat(spinTimes) { index ->
        val discount = Random.nextInt(10)
        println("Attempt ${index+1}: $discount")
        if(discount>maximumDiscountValue){
            maximumDiscountValue=discount
        }
    }
    println("You won $maximumDiscountValue% discount for your next purchase.")
}

fun main() {
    spin(3)
}


