package com.app.littlelemoningredients

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class IngredientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient)

        val passedString = intent.getStringExtra(EXTRA_DISH_NAME_KEY)

        findViewById<TextView>(R.id.ingredient_list).text=when(passedString){
            "Hamburger" -> "Minced meat\nBun\nTomato"
            "Pasta" -> "Spaghetti\nTomato\nParmesan"
            else -> "Unknown Dish"
        }
    }

    companion object{
        private const val EXTRA_DISH_NAME_KEY="DishName"

        fun start(context: Context,dishName:String){
            val intent=Intent(context,IngredientActivity::class.java)
            intent.putExtra(EXTRA_DISH_NAME_KEY,dishName)
            context.startActivity(intent)
        }

    }
}