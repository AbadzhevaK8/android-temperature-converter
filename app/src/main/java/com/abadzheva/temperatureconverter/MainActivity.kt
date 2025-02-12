package com.abadzheva.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun TemperatureText(celsius: Int) {
    val fahrenheit = (celsius.toDouble() * 9 / 5) + 32
    Text("$celsius Celsius is $fahrenheit Fahrenheit")
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun ConvertButton(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("Convert")
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun Header(
    image: Int,
    description: String,
) {
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier =
            Modifier
                .height(180.dp)
                .fillMaxWidth(),
        contentScale = ContentScale.Crop,
    )
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun MainActivityContent() {
    val celsius = remember { mutableStateOf(0) }

    Column {
        Header(R.drawable.sunrise, "Sunrise")
        ConvertButton { celsius.value = 20 }
        TemperatureText(celsius.value)
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    MainActivityContent()
}
