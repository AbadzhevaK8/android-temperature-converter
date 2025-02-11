package com.abadzheva.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column {
                Hello("friend")
                Hello("everyone")
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun Hello(name: String) {
    Text("Hello $name! Welcome to Jetpack Compose.")
}
