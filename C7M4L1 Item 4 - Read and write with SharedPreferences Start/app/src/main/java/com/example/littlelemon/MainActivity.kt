package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {

    private var tipMenuLiveDatafield = MutableLiveData<Boolean>()

    private val sharedPreferences by lazy {
        getSharedPreferences("LittleLemon",Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tipMenuLiveDatafield.value = sharedPreferences.getBoolean("Tip",false)

        setContent {
            LittleLemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Text(text = "Add Tip?")

                        val selected = tipMenuLiveDatafield.observeAsState(false)
                        Switch(checked = selected.value, onCheckedChange = {
                            sharedPreferences.edit(){
                                putBoolean("Tip",it).commit()
                            }
                            runOnUiThread {
                                tipMenuLiveDatafield.value=it
                            }
                        })
                    }
                }
            }
        }
    }
}
