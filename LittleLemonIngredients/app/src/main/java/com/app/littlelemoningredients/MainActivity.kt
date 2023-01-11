package com.app.littlelemoningredients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.main_dish1).setOnClickListener{
            IngredientActivity.start(this,"Hamburger")
        }
        findViewById<View>(R.id.main_dish2).setOnClickListener{
            IngredientActivity.start(this,"Pasta")
        }
    }
}