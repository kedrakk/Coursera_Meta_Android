package com.app.littlelemoningredients

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TestLambdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_lambda)

        val saveDataButton = findViewById<Button>(R.id.saveDataButton)
        saveDataButton.setOnClickListener {
            Toast.makeText(
                this,
                "Data Saved",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

fun main() {
    var sum = 0

    val numberList = listOf(1, 4, 6, 7, 9)
    numberList.forEach { number ->
        sum += number
    }
    println(sum)
}