package com.app.littlelemoningredients

import org.junit.Assert.assertEquals
import org.junit.Test

 class ProductTest{

    @Test
    fun applyDiscount_lessThanFive_discountApplied() {
        val product = Product("Spaghetti", 20.00, 3)
        product.applyDiscount(20)
        assertEquals(16.00, product.price, 0.0)
    }

    @Test
    fun applyDiscount_moreThanFive_discountNotApplied() {
        val product = Product("Steak", 30.00, 8)
        product.applyDiscount(20)
        assertEquals(30.00, product.price, 0.0)
    }

    @Test
    fun applyDiscount_outOfStock_discountNotApplied() {
        val product = Product("Lasagna", 10.00, 0)
        product.applyDiscount(20)
        assertEquals(10.00, product.price, 0.0)
    }
}