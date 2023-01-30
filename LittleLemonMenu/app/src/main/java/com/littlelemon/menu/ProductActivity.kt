package com.littlelemon.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val title = intent.getStringExtra(KEY_TITLE)
        val price = intent.getDoubleExtra(KEY_PRICE,0.0)
        val category = intent.getStringExtra(KEY_CATEGORY)
        val image = intent.getIntExtra(KEY_IMAGE,R.drawable.ic_launcher_foreground)
        val productItem =
            ProductItem(title.toString(), price = price, category.toString(), image)
        setContent { ProductDetails(productItem) }
    }

    companion object{
        const val KEY_TITLE = "title"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"
    }
}