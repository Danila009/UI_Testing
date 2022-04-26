package com.example.uitesting

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Button(
                    modifier = Modifier
                        .testTag("button"),
                    onClick = {
                        Toast.makeText(
                            this@MainActivity,
                            "Testing",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ){}

                Text(text = "Compose testing")

                Number{}
            }
        }
    }
}

@Composable
fun Number(
    numberUnit:(Int) -> Unit
) {
    val number by remember { mutableStateOf(10) }

    Button(
        onClick = {
            numberUnit(100)
       },
        modifier = Modifier.testTag("click_number")
    ) {
        Text(text = "Click number")
    }
}
